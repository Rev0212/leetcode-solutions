class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1){amount + 1}
        dp[0] = 0
        for(i in 1 until amount+1){
            for(j in coins){
                if(i >= j)
                dp[i] = minOf(dp[i], (1+dp[i-j]))
            }
        }
        if(dp[amount] == amount+1){
            return -1 
        } else {
        return dp[amount] 
        }
    }
}

/*
## Coin Change — DP Revision Notes

**Core idea:** Build answers for smaller amounts first, then reuse them to calculate answers for larger amounts.

**DP state:**
`dp[i]` = minimum number of coins required to make amount `i`.

**Base case:**
`dp[0] = 0` — zero coins are needed to make amount `0`.

**Recurrence:**
```kotlin
dp[i] = minOf(dp[i], 1 + dp[i - coin])
```

- Try every available coin where `coin <= i`.
- `dp[i - coin]` = minimum coins needed for the remaining amount.
- `+1` counts the coin chosen in the current step.
- `minOf` keeps the best answer across all possible coin choices.

**Initialization:**
Initialize other entries to `amount + 1`, an impossible upper bound, so valid candidates can replace it.

**Impossible amount:**
If `dp[amount] == amount + 1`, return `-1`.

**Complexity:**
- Time: `O(amount × coins.size)`
- Space: `O(amount)`

**Important:** `dp[i]` is the minimum number of coins of *any available denomination* needed to make amount `i`—not the number of ₹1 coins.

**Example:** With coins `[1, 2, 5]`:
- `dp[1] = 1`
- `dp[2] = 1`
- `dp[3] = 2`
- `dp[4] = 2`
- `dp[11] = 3` (5 + 5 + 1)
 */
