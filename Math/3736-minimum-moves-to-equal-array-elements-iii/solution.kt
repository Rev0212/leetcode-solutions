class Solution {
    fun minMoves(nums: IntArray): Int {
        var count = 0
        val max = nums.maxOrNull()!!
        for(i in nums){
            if(i < max){
                count += max - i 
            }
        }

        return count 
    }
}
