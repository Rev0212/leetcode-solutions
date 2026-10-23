class Solution {
    fun findWords(words: Array<String>): Array<String> {
        val rowMap = mutableMapOf<Char, Int>()
    
        for(c in "qwertyuiop"){
            rowMap[c] = 1
        }

        for(c in "asdfghjkl"){
            rowMap[c] = 2
        }

        for(c in "zxcvbnm"){
            rowMap[c] = 3
        }

        val result = mutableListOf<String>()

        for(c in words){
            val lowerWord = c.lowercase()
            val expectedRow = rowMap[lowerWord[0]]!!
            var valid = true
            for(i in lowerWord){
                if (rowMap[i] != expectedRow) {
                    valid = false
                    break
                }
            }
            if(valid){
                result.add(c)
            }
        }

        return result.toTypedArray()
    }
}
