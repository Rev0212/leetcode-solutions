class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
         position.sort()
         var low = 1 
         var high = position.last() - position.first() 

        while(low <= high){
            var canPlace = false 
            var placed = 1
            var lastPlaced = position[0]
            val mid = low + (high - low)/2
            for(i in 1 until position.size){
                if(position[i] - lastPlaced >= mid){
                    lastPlaced = position[i]
                    placed++
                }

                if(placed == m){
                    canPlace = true
                    break
                }
            }
            if(canPlace){
                low = mid + 1
            } else {
                high = mid - 1 
            }
        }

        return high
    }
}
