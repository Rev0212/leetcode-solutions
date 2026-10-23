class Solution {
    fun removeStars(s: String): String {
        val stack = ArrayDeque<Char>()

        for (i in s.indices){
            if(s[i] != '*'){
                stack.addLast(s[i])
            } else if(s[i] == '*'){
                stack.removeLast()
            }
        }

        return stack.joinToString("")


    }
}
