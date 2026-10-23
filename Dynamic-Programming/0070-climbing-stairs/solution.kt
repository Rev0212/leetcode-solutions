class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n+1)
        
        if(n<= 1){return n}

        dp[1] = 1 
        dp[2] = 2
        for(i in 3..n){
            dp[i] = dp[i-2] + dp[i-1]
        }

        return dp[n]
    }
}
