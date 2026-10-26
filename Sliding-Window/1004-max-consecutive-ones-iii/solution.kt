class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var maxLen = 0
        var i = 0 
        var j = 0
        var switched = 0

        while(j < nums.size){
            if(nums[j] == 0 ){
                switched++
            }

            while(switched > k){
                if(nums[i] == 0){
                    switched--
                }
                i++
            }

            val len = j - i + 1
            maxLen = maxOf(len, maxLen)
            j++
        }

        return maxLen
    }
}
