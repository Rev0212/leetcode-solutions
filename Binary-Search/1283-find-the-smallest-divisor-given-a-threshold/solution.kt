class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var low = 1
        var high = nums.maxOrNull()!!

        var minDivisor = Int.MAX_VALUE

        while(low <= high){
            val mid = low + (high-low)/2
            var sum = 0

            for(i in nums){
                val res = (i + mid - 1)/ mid
                sum += res
            }

            if(sum <= threshold){
                minDivisor = minOf(minDivisor, mid)
            }

            if (sum <= threshold){
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return minDivisor
    }
}
