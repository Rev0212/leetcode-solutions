class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        for(i in nums){
            map[i] = map.getOrDefault(i, 0) + 1
        }
        for((i, k) in map){
            if(k >= 2){
                return true
            }
        }
        return false
    }
}
