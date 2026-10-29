class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var low = 1
        var high = piles.maxOrNull()!!

        while(low <= high){
            val mid = low + (high - low) /2
            var hours = 0L

            for(pile in piles){
                hours += (pile.toLong() + mid - 1) / mid
            }

            if(hours > h){
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return low


    }
}
