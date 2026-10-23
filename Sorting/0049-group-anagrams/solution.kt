class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
       val groups = HashMap<String, MutableList<String>>()

       for(word in strs){
        val map = IntArray(26)
            for (c in word) {
                map[c - 'a']++
            }

        val key = map.contentToString()

        groups.getOrPut(key){mutableListOf()}.add(word)

       }

        return groups.values.toList()

    }
}
