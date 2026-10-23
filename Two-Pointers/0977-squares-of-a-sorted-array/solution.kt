class Solution {
     fun sortedSquares(nums: IntArray): IntArray {
        var ans = IntArray(nums.size) 
        var left = 0;
        var right = nums.size - 1
        var pos = nums.size - 1

        while(left<=right){
            val sqrOfLeft = nums[left] * nums[left]
            val sqrOfRight = nums[right] * nums[right]

            if(sqrOfLeft > sqrOfRight){
                ans[pos] = sqrOfLeft
                left++
            } else {
                ans[pos] = sqrOfRight
                right--
            }
            pos--
        } 
        return ans
    }
}
