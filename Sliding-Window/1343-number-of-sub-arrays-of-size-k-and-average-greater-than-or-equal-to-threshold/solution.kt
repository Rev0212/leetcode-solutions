class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var count = 0
        var sum = arr.take(k).sum()
        if(sum/k >= threshold ){
            count++
        }

        for(i in k until arr.size){
            val currSum = sum - arr[i-k] + arr[i]
            if(currSum/k >= threshold){
                count++ 
            } 
            sum = currSum
        }

        return count
    }
}
