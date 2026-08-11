class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // recursion  + memoization
        // val dp = HashMap<Pair<Int, Int>, Int>()
        // val n = coins.size
        // val INF = Int.MAX_VALUE / 2
        // fun recursion(i: Int, rem: Int): Int {
        //     val key = Pair(i, rem)
        //     if(dp.containsKey(key)) {
        //         return dp[key]!!
        //     }
        //     if (rem == 0) return 0
        //     if(rem < 0) return INF
        //     if(i == n) return INF
        //     val res = min(1 + recursion(i, rem - coins[i]),  recursion (i+1, rem))
        //     dp[key] = res
        //     return res
        // }

        // val res = recursion(0, amount)
        // return if(res >= INF) -1 else res


        val dp = IntArray(amount + 1) {amount + 1}
        dp[0] = 0

        for(a in 1..amount) {
            for(coin in coins) {
                if(a - coin >= 0) {
                    dp[a] = min(dp[a], 1 + dp[a-coin])
                }
            }
        }

        return if(dp[amount] > amount) -1 else dp[amount]
    }
}
