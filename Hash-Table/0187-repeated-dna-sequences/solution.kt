class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
    
        if (s.length < 10) {
            return emptyList()
        }

         val map = mutableMapOf<String, Int>()
         val result =  mutableListOf<String>()

        for(i in 0..s.length - 10){
            val sequence = s.substring(i, i + 10)
            map[sequence] = map.getOrDefault(sequence, 0) + 1
        }

        for ((sequence, count) in map) {
            if (count > 1) {
                result.add(sequence)
            }
        }


        return result


    }
}
