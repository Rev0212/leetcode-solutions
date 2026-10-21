
## How syncing works

All raw solutions live in [`data/submissions.json`](data/submissions.json). [`sync.py`](sync.py) turns them into the topic folders and this README.

**Automatic (GitHub Actions)** — the workflow in `.github/workflows/sync.yml` runs daily and on demand (Actions → *Sync LeetCode* → *Run workflow*). To let it pull new submissions, add two repo secrets (Settings → Secrets and variables → Actions) from your leetcode.com browser cookies:

- `LEETCODE_SESSION` — value of the `LEETCODE_SESSION` cookie
- `LEETCODE_CSRF` — value of the `csrftoken` cookie

The session cookie expires every few weeks; refresh the secret when the workflow log says fetch failed.

**Manual (locally)**

```bash
export LEETCODE_SESSION=... LEETCODE_CSRF=...
python sync.py          # fetch new accepted submissions + rebuild folders
git add -A && git commit -m "Sync LeetCode" && git push
```
