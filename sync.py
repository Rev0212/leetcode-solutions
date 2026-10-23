#!/usr/bin/env python3
"""
LeetCode -> GitHub, organized by question type (topic tag).

Commands
  python sync.py fetch   # pull new accepted submissions into data/submissions.json
                         # needs env LEETCODE_SESSION and LEETCODE_CSRF (browser cookies)
  python sync.py build   # (re)generate the topic folders + README from data/submissions.json
  python sync.py         # fetch (if cookies are set) then build

Layout produced
  <Topic>/<id>-<slug>/solution.<ext>   (one file per language)
  <Topic>/<id>-<slug>/README.md        (title, difficulty, all tags, link)
  README.md                            (index grouped by topic)

Each problem lives in the folder of its main pattern: the first PRIORITY tag it has (e.g. DP over Array/Math).
"""
import json
import os
import re
import shutil
import sys
import time
import urllib.request
from collections import defaultdict
from datetime import datetime, timezone

ROOT = os.path.dirname(os.path.abspath(__file__))
DATA = os.path.join(ROOT, "data", "submissions.json")
MARKER = ".generated"  # topic folders we own carry this file, so rebuilds can clean them safely
# folder = first of these patterns the problem is tagged with (most specific technique first); falls back to LeetCode's first tag
PRIORITY = ["Dynamic Programming", "Backtracking", "Graph Theory", "Topological Sort", "Depth-First Search", "Breadth-First Search", "Binary Tree", "Tree", "Trie", "Heap (Priority Queue)", "Monotonic Stack", "Stack", "Linked List", "Sliding Window", "Binary Search", "Two Pointers", "Prefix Sum", "Greedy", "Bit Manipulation", "Sorting", "Hash Table", "Union-Find", "String", "Math", "Array"]

EXT = {
    "cpp": "cpp", "c": "c", "java": "java", "python": "py", "python3": "py",
    "kotlin": "kt", "javascript": "js", "typescript": "ts", "golang": "go",
    "rust": "rs", "swift": "swift", "scala": "scala", "ruby": "rb", "php": "php",
    "csharp": "cs", "dart": "dart", "elixir": "ex", "racket": "rkt", "erlang": "erl",
    "mysql": "sql", "mssql": "sql", "oraclesql": "sql", "postgresql": "sql",
    "pythondata": "py", "bash": "sh",
}


# ---------------------------------------------------------------- fetch
def _req(url, session, csrf, body=None):
    headers = {
        "Cookie": f"LEETCODE_SESSION={session}; csrftoken={csrf}",
        "x-csrftoken": csrf,
        "Referer": "https://leetcode.com/",
        "User-Agent": "Mozilla/5.0 leetcode-sync",
        "Content-Type": "application/json",
    }
    data = json.dumps(body).encode() if body is not None else None
    for attempt in range(5):
        try:
            with urllib.request.urlopen(urllib.request.Request(url, data, headers), timeout=30) as r:
                return json.loads(r.read())
        except Exception as e:  # rate limits etc.
            if attempt == 4:
                raise
            time.sleep(2 * (attempt + 1))


def load():
    if os.path.exists(DATA):
        with open(DATA, encoding="utf-8") as f:
            return json.load(f)
    return []


def save(items):
    os.makedirs(os.path.dirname(DATA), exist_ok=True)
    items.sort(key=lambda s: (int(s.get("questionFrontendId") or 0), s["lang"]))
    with open(DATA, "w", encoding="utf-8") as f:
        json.dump(items, f, indent=1, ensure_ascii=False)


def fetch():
    session, csrf = os.environ.get("LEETCODE_SESSION"), os.environ.get("LEETCODE_CSRF")
    if not session or not csrf:
        print("fetch skipped: set LEETCODE_SESSION and LEETCODE_CSRF to pull new submissions")
        return
    have = {(s["slug"], s["lang"]): s for s in load()}
    newest = max((s["timestamp"] for s in have.values()), default=0)

    latest, offset, lastkey = {}, 0, ""
    while True:
        j = _req(f"https://leetcode.com/api/submissions/?offset={offset}&limit=20&lastkey={lastkey}", session, csrf)
        dump = j.get("submissions_dump", [])
        for s in dump:
            if s.get("status_display") != "Accepted":
                continue
            k = (s["title_slug"], s["lang"])
            if k not in latest or latest[k]["timestamp"] < s["timestamp"]:
                latest[k] = s
        # list is newest-first: stop once we're past what we already have
        if not j.get("has_next") or (dump and dump[-1]["timestamp"] < newest):
            break
        offset += 20
        lastkey = j.get("last_key", "")
        time.sleep(0.5)

    changed = 0
    for k, s in latest.items():
        old = have.get(k)
        if old and old["timestamp"] >= s["timestamp"]:
            continue
        meta = old or _req("https://leetcode.com/graphql/", session, csrf, {
            "query": "query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty topicTags{name slug}}}",
            "variables": {"s": k[0]},
        })["data"]["question"]
        have[k] = {
            "slug": k[0], "lang": k[1], "code": s["code"], "timestamp": s["timestamp"],
            "runtime": s.get("runtime"), "memory": s.get("memory"),
            "questionFrontendId": meta["questionFrontendId"], "title": meta["title"],
            "difficulty": meta["difficulty"], "topicTags": meta["topicTags"],
        }
        changed += 1
    for slug in {v["slug"] for v in have.values() if not v.get("content")}: c = _req("https://leetcode.com/graphql/", session, csrf, {"query": "query q($s:String!){question(titleSlug:$s){content}}", "variables": {"s": slug}})["data"]["question"]["content"] or ""; [v.update(content=c) for v in have.values() if v["slug"] == slug]; time.sleep(0.3)
    save(list(have.values()))
    print(f"fetch: {changed} new/updated solutions")


# ---------------------------------------------------------------- build
def folder_name(tag):
    return re.sub(r"[^A-Za-z0-9]+", "-", tag).strip("-")


def build():
    items = load()
    if not items:
        print("build: no data")
        return

    # wipe previously generated topic folders
    for d in os.listdir(ROOT):
        p = os.path.join(ROOT, d)
        if os.path.isdir(p) and os.path.exists(os.path.join(p, MARKER)):
            shutil.rmtree(p)

    problems = defaultdict(list)
    for s in items:
        problems[s["slug"]].append(s)

    by_topic = defaultdict(list)
    for slug, sols in problems.items():
        q = sols[0]
        tags = [t["name"] for t in (q.get("topicTags") or [])] or ["Uncategorized"]
        topic = folder_name(next((p for p in PRIORITY if p in tags), tags[0]))
        pid = f"{int(q['questionFrontendId']):04d}" if str(q["questionFrontendId"]).isdigit() else q["questionFrontendId"]
        pdir = os.path.join(ROOT, topic, f"{pid}-{slug}")
        os.makedirs(pdir, exist_ok=True)
        open(os.path.join(ROOT, topic, MARKER), "w").close()

        langs = []
        for s in sorted(sols, key=lambda x: x["lang"]):
            ext = EXT.get(s["lang"], s["lang"])
            name = f"solution.{ext}" if sum(EXT.get(x["lang"]) == ext for x in sols) == 1 else f"solution_{s['lang']}.{ext}"
            with open(os.path.join(pdir, name), "w", encoding="utf-8") as f:
                f.write(s["code"].rstrip() + "\n")
            langs.append((s["lang"], name, s))

        url = f"https://leetcode.com/problems/{slug}/"
        with open(os.path.join(pdir, "README.md"), "w", encoding="utf-8") as f:
            f.write(f"# {q['questionFrontendId']}. {q['title']}\n\n")
            f.write(f"**Difficulty:** {q['difficulty']}  \n**Topics:** {', '.join(tags)}  \n**Link:** {url}\n\n")
            if q.get("content"): f.write("## Question\n\n" + q["content"].strip() + "\n\n## Solutions\n\n")
            f.write("| Language | File | Runtime | Memory | Accepted |\n|---|---|---|---|---|\n")
            for lang, name, s in langs:
                when = datetime.fromtimestamp(int(s["timestamp"]), timezone.utc).strftime("%Y-%m-%d")
                f.write(f"| {lang} | [{name}]({name}) | {s.get('runtime') or ''} | {s.get('memory') or ''} | {when} |\n")
        by_topic[topic].append((q, slug, pid, tags, [l for l, _, _ in langs]))

    # root README
    out = ["# LeetCode Solutions — by Question Type\n",
           f"{len(problems)} problems, {len(items)} solutions, {len(by_topic)} topics. "
           "Each problem is filed under its primary LeetCode topic; all its tags are listed alongside.\n",
           "Auto-generated by [`sync.py`](sync.py) — see [How syncing works](#how-syncing-works).\n",
           "## Topics\n"]
    out.append(" · ".join(f"[{t.replace('-', ' ')}](#{t.lower()}) ({len(v)})"
                          for t, v in sorted(by_topic.items(), key=lambda kv: (-len(kv[1]), kv[0]))) + "\n")
    for topic in sorted(by_topic):
        out.append(f"\n## {topic}\n\n| # | Problem | Difficulty | Tags | Languages |\n|---|---|---|---|---|")
        for q, slug, pid, tags, langs in sorted(by_topic[topic], key=lambda x: int(x[0]["questionFrontendId"]) if str(x[0]["questionFrontendId"]).isdigit() else 0):
            out.append(f"| {q['questionFrontendId']} | [{q['title']}]({topic}/{pid}-{slug}/) | {q['difficulty']} | "
                       f"{', '.join(tags)} | {', '.join(langs)} |")
    out.append(open(os.path.join(ROOT, "data", "HOWTO.md"), encoding="utf-8").read()
               if os.path.exists(os.path.join(ROOT, "data", "HOWTO.md")) else "")
    with open(os.path.join(ROOT, "README.md"), "w", encoding="utf-8") as f:
        f.write("\n".join(out).rstrip() + "\n")
    print(f"build: {len(problems)} problems into {len(by_topic)} topic folders")


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "all"
    if cmd in ("fetch", "all"):
        try:
            fetch()
        except Exception as e:
            print(f"::warning::fetch failed (cookie expired?): {e}")
            if cmd == "fetch":
                sys.exit(1)
    if cmd in ("build", "all"):
        build()
