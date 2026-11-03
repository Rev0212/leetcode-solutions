class Solution {
    fun minMoves2(nums: IntArray): Int {
        val arr = nums.sort() 
        val mid = nums.size / 2
        val target = nums[mid]

        var moves = 0

        for(i in nums){
            if(i != target){
                moves += abs(target - i)
            }
        }

        return moves
    }
}
