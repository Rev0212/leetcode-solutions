class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size.toLong() < m.toLong() * k.toLong()){
            return - 1
        }

        var low = bloomDay.minOrNull()!!
        var high = bloomDay.maxOrNull()!!

        var total = 0
    
        while(low <= high){
            var adj = 0
            val mid = low + (high - low)/2

            for(i in bloomDay){
                if(i <= mid){
                    adj++
                } else {
                    adj = 0
                }
                if(adj == k){
                   total++ 
                   adj = 0
                }
            }


            if(total >= m){
                high = mid - 1
            } else {
                low = mid + 1
            }

            total = 0
        }

        return low

    }
}
