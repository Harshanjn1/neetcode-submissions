class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1
        var maxProfit = 0

        while (r < prices.size) {
            if(prices[l] < prices[r]) {
                maxProfit = max(maxProfit, prices[r] - prices[l])
            } else {
                l = r
            }
            r++
        }
        return maxProfit
    }
}
