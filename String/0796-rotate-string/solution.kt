class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if(s.length != goal.length){
            return false
        }

        val res = s + s

        if(res.contains(goal)){
            return true
        }

        return false

    }
}
