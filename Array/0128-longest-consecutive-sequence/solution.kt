class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()

        for(num in nums){
            set.add(num)
        }

        
        var maxCount = 0


        for(num in set){
            if(!set.contains(num-1)){
                var current = num
                var count = 1

                while(set.contains(current + 1)){
                    count++
                    current++
                }

                 maxCount = maxOf(maxCount, count)

            }
        }

        return maxCount

    }
}
