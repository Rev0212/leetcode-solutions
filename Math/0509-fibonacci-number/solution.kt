class Solution {
    fun fib(n: Int): Int {
        val dp = IntArray(n+1){-1}
        if(n<=1){return n}
        dp[0] = 0
        dp[1] = 1

        for(i in 2..n){
            dp[i] = dp[i-2] + dp[i-1]
        }

        return dp[n]
    }
}
