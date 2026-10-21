class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length ){
            return false
        }
        val m1 = mutableMapOf<Char, Char>()
        val m2 = mutableMapOf<Char, Char>()

        for(i in s.indices){
           val c1 = s[i]
           val c2 = t[i]

            if(m1.contains(c1) && m1[c1] != c2){
                return false
            }

            if(m2.contains(c2) && m2[c2] != c1){
                return false
            }

            m1[c1] = c2
            m2[c2] = c1
        }

        return true
    }
}
