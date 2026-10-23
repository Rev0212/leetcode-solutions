
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (i in nums) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in map) {
            buckets[freq].add(num)
        }

        val ans = mutableListOf<Int>()

        for (i in buckets.size - 1 downTo 1) {
            for (num in buckets[i]) {
                ans.add(num)

                if (ans.size == k) {
                    return ans.toIntArray()
                }
            }
        }

        return ans.toIntArray()
    }
}
