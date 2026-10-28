class Solution {
    fun reverseWords(s: String): String {
        val sArr = s.trim().split("\\s+".toRegex())
        return sArr.reversed().joinToString(" ")
    }
}
