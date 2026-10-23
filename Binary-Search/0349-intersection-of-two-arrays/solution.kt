class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set = mutableSetOf<Int>()
        for(i in nums1){
            set.add(i)
        }

        val res = mutableSetOf<Int>()
        for(i in nums2){
            if(set.contains(i)){
                res.add(i)
            }
        }

        return res.toIntArray()

    }
}
