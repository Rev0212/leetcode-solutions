class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = nums.take(k).sum()
        var maxSum = sum

        for (i in k until nums.size) {
            sum = sum - nums[i - k] + nums[i]
            maxSum = maxOf(maxSum, sum)
        }

        return maxSum.toDouble() / k
    }
}
