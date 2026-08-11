class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        //Top Down Approach
        //-----------------------------
        // val dp = Array(coins.size + 1) {IntArray(amount + 1) {-1}}
        // fun recursion(i: Int, remAmount: Int): Int {
        //     if(remAmount == 0) return 1

        //     if(i >= coins.size ) return 0

        //     if(dp[i][remAmount] != -1) return dp[i][remAmount]

        //     var res = 0
        //     if(remAmount >= coins[i]) {
        //         res = recursion(i+1, remAmount)
        //         res += recursion(i, remAmount - coins[i])
        //     }
        //     dp[i][remAmount] = res

        //     return res
        // }

        // return recursion(0, amount)

        // Bottom-Up approach
        //--------------------------------------------------

        // val n = coins.size
        // val dp = Array(n+1) { IntArray(amount + 1) }

        // for(i in 0..n) {
        //     dp[i][0] = 1
        // }

        // for(i in n-1 downTo 0) {
        //     for(am in 0..amount) {
        //         if(am >= coins[i]) {
        //             dp[i][am] = dp[i+1][am]
        //             dp[i][am] += dp[i][am - coins[i]]
        //         } else {
        //             dp[i][am] = dp[i+1][am]
        //         }
        //     }
        // }
        // return dp[0][amount]

        // space optimisation
        //------------------------
        val n = coins.size
        var dp = IntArray(amount + 1)
        dp[0] = 1

        for(i in n-1 downTo 0) {
            val nextDp = IntArray(amount+1)
            nextDp[0] = 1
            for(am in 0..amount) {
                nextDp[am] = dp[am]
                if(am >= coins[i]) {
                    nextDp[am] += nextDp[am - coins[i]]
                }
            }
            dp = nextDp
        }
        return dp[amount]

    }
}
