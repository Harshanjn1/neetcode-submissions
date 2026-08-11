class Solution {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        var res = 0
        if(size <= 1) {
            return res
        }
        var l = 0
        var r = 1

        while (r < size) {
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
