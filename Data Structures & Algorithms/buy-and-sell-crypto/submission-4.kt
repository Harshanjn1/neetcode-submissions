class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1
        var res = 0

        while(r < prices.size) {
            if(prices[l] < prices[r]) {
                res = max(res, prices[r] - prices[l])
            } else {
                l = r
            }
            r++
        }
        return res
    }
}
