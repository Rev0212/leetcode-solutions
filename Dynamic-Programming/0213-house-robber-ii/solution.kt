class Solution {
    fun rob(nums: IntArray): Int {

        if(nums.size <= 1){
            return nums[0]
        }


        val lootA = IntArray(nums.size)
        lootA[0] = nums[0]
        lootA[1] = maxOf(nums[0], nums[1])

        val lootB = IntArray(nums.size)
        lootB[0] = 0
        lootB[1] = nums[1]
        

        //case1 
        for(i in 2 until nums.size - 1){
            lootA[i] = maxOf(lootA[i-1], (nums[i]+lootA[i-2]))
        }

        //case2
        for (i in 2 until nums.size){
            lootB[i] = maxOf(lootB[i-1], (nums[i]+lootB[i-2]))
        }

        return max(lootB[nums.size-1], lootA[nums.size-2])


    }
}


// 2
// 3
// 2

// 13
// 21

// size -> 3
// index 0 rob -> i cant rob index[2] so i can rob untill index[1] this is size -2 

// inex 1 rob -> i cant rob untill index[2] this is size -1
