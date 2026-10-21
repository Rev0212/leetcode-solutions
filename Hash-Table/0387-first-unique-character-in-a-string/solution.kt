class Solution {
    fun firstUniqChar(s: String): Int {
      val map = mutableMapOf<Char, Int>()

      for(i in s){
        map[i] = map.getOrDefault(i, 0) + 1
      }

      for(i in s.indices){
        if(map[s[i]] == 1){
            return i
        }
      }

      return -1
    }

}
