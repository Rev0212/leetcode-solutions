class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        var i = 0 
        val set = HashSet<Int>()

        while( i < nums.size){
            if(i > k){
                set.remove(nums[i-k-1])
            }

            if(nums[i] in set){
                return true
            }

            set.add(nums[i])

            i++ 
        }

        return false
    }
}
