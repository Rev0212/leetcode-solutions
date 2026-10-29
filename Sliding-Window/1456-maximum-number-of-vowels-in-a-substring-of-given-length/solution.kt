class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var currCount = 0
        var i = 0

        while(i < k){
            if(isVowel(s[i])){
                currCount++
            } 
            i++
        }

        var maxCount = currCount
        i = k

        while(i < s.length){
            if(isVowel(s[i])){
                currCount++
            }

            if(isVowel(s[i-k])){
                currCount--
            }

            maxCount = maxOf(currCount, maxCount)

            i++
        } 

        return maxCount
    }

    fun isVowel(c: Char): Boolean{
        val set = setOf('a', 'e', 'i', 'o', 'u')
        
        return c in set
    }
}
