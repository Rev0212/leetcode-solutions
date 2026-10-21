class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        val magazineMap = mutableMapOf<Char, Int>()         
        
        for(i in magazine){
            magazineMap[i] = magazineMap.getOrDefault(i, 0) + 1
        }

        for(i in ransomNote){
            val count = magazineMap.getOrDefault(i, 0)

            if(count == 0){
                return false
            }

            magazineMap[i] = count - 1

            
        }

        return true

    }
}

//TC --> O(n+m)
