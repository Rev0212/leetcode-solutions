class Solution {
    fun maxArea(height: IntArray): Int {
        var p1 = 0
        var p2 = height.size - 1

        var best = 0

        while(p1 != p2){
            val width = p2 - p1
            val heightMin = minOf(height[p1], height[p2])
            val area = width * heightMin
            best = maxOf(area, best)

            if(height[p1] > height[p2]){
                p2--
            } else {
                p1++
            }

        }

        return best


    }
}
