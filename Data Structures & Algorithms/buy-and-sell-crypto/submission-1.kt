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
            res = max(res, prices[r] - prices[l])

            if(prices[r] < prices[l] ) {
                l = r
                r++
            } else {
                r++
            }
        }

        return res
    }
}
