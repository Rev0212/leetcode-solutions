class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longSubsrting = 0
        var i = 0
        var j = 0

        var unique = mutableSetOf<Char>()

        while(j < s.length){

            while(i <= j){
                if(unique.contains(s[j])){
                unique.remove(s[i])
                i++ 
            } else {
                unique.add(s[j])
                break
            }

            }
                val len = j - i + 1
                longSubsrting = maxOf(len, longSubsrting)
                j++
        }

        return longSubsrting
    }
}
