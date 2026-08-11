class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.size - 1
        var res = 0
        while (l < r) {
            // find out the amount of water we can trap between l and r
            val amount = min(heights[l], heights[r]) * (r - l)
            if(heights[l] < heights[r]) {
                l++
            } else {
                r--
            }

            res = max(res, amount)
        }

        return res
    }
}
