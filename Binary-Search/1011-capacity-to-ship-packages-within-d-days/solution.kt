class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var low = weights.maxOrNull()!!
        var high = weights.sum()

        var minCapacity = Int.MAX_VALUE
        

        while(low <= high){
            val mid = low + (high-low) / 2
            var daysReq = 1
            var capacity = 0

            for(i in weights){
                if(capacity + i > mid){
                    daysReq++
                    capacity = 0 
                }
                capacity += i
            }

            if(daysReq <= days){
                 minCapacity = minOf(minCapacity, mid)
            }

            if(daysReq > days){
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return minCapacity 
    }
}
