class Solution {
    fun plusOne(nums: IntArray): IntArray {
        val n = nums.size

        for (i in n - 1 downTo 0) {
            if (nums[i] < 9) {
                nums[i]++
                return nums
            }

            nums[i] = 0
        }

        return intArrayOf(1) + nums
    }
}
