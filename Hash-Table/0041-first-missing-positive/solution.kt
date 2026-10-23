class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val arr = BooleanArray(nums.size + 1)
        for(i in nums.indices){
            if(nums[i] > 0 &&  nums[i] <= nums.size){
                arr[nums[i]] = true 
            }
        }

        for(x in 1 until arr.size){
            if(arr[x] == false){
                return x
            }
        }

        return nums.size + 1

    }
}
