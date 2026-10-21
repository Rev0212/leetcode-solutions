class Solution {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        for (i in s){
            map[i] = map.getOrDefault(i, 0) + 1
        }

        var res = 0
        var hasOdd = false

        for((i, c) in map){
            if( c % 2 == 0){
                res += c
            } else {
                hasOdd = true
                res += c - 1
            } 
        }

        if(hasOdd){
            res += 1
        }

        return res


    }
}
