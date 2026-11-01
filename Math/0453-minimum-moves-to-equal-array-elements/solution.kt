class Solution {
    fun minMoves(nums: IntArray): Int {
        val min = nums.minOrNull()!!
        var step = 0

        for(i in nums){
            if (i > min){
                step += i - min 
            }
        }

        return step 
    }
}
