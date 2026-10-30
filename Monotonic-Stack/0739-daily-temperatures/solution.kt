class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val arr = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for (i in temperatures.indices){
            while(!stack.isEmpty()  &&
             temperatures[stack.last()] < temperatures[i]
             ){
               val top = stack.last()
               arr[top] = i - top
               stack.removeLast()
            }
            stack.addLast(i)
        }

        return arr
     
    }
}
