class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var i = 0
        var j = 0
        var currSum = 0
        var minLen = Int.MAX_VALUE

        while (j < nums.size) {
            currSum += nums[j]

            while (currSum >= target) {
                val len = j - i + 1
                minLen = minOf(minLen, len)

                currSum -= nums[i]
                i++
            }

            j++
        }

        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}
