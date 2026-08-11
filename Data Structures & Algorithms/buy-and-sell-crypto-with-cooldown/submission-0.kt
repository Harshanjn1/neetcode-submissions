class Solution {
    fun maxProfit(prices: IntArray): Int {
        // top-down approach
        // -----------------------------------------
        // val dp = HashMap<Pair<Int, Boolean>, Int>()
        // fun recursion(i: Int , isBuying: Boolean): Int {
        //     if(i >= prices.size) return 0
        //     val key = Pair(i, isBuying)
        //     if(key in dp) return dp[key]!!
        //     // even when there is an option to buy or sell , we can always choose to not 
        //     // take any action we can just skip the transaction for the day
        //     val skip = recursion(i + 1, isBuying)

        //     dp[key] =  if(isBuying) {
        //         max(skip, (recursion(i+1, false) - prices[i]))
        //     } else {
        //         max(skip, (recursion(i+2, true) + prices[i]))
        //     }
        //     return dp[key]!!
        // }

        // return recursion(0, true)

        // bottom-up approach
        // ------------------------

        val n = prices.size
        //val dp = Array(n+1) {IntArray(2)}

        var dp1_buy = 0
        var dp1_sell = 0
        var dp2_buy = 0

        for(i in n-1 downTo 0) {
            val dp_buy = max(dp1_sell - prices[i], dp1_buy)
            val dp_sell = max(dp2_buy + prices[i], dp1_sell)

            dp2_buy = dp1_buy
            dp1_buy = dp_buy
            dp1_sell = dp_sell
        }

        return dp1_buy
    }
}
