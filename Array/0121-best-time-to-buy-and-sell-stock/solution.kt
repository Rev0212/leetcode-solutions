class Solution {
    fun maxProfit(prices: IntArray): Int {
      if (prices.size < 2) return 0

        var maxProfit = 0
        var minCostPrice = prices[0]

        for(i in 1 until prices.size){
            val profit = prices[i] - minCostPrice
            maxProfit = maxOf(profit, maxProfit)
            minCostPrice = minOf(prices[i], minCostPrice)
        }

        return maxProfit
    }
}
