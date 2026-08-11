class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        // Bottom-Up Approach
        // -----------------------------
        // val n = nums.size
        // var totalSum = nums.sum()
        // val dp = Array(n+1) {IntArray(2 * totalSum + 1) {Int.MIN_VALUE}}
        // fun recursion(i: Int, total: Int): Int {
        //     if(i == n) {
        //         return if(total == target) 1 else 0
        //     }

        //     if(dp[i][total + totalSum] != Int.MIN_VALUE) return dp[i][total + totalSum]

        //     dp[i][total + totalSum] =  recursion(i+1, total - nums[i]) + recursion(i+1, total + nums[i])

        //     return dp[i][total + totalSum]
        // }

        // return recursion(0, 0)

        // Top-Down Approach
        // -----------------------------

        val n = nums.size
        val dp = mutableMapOf<Int, Int>(0 to 1)

        for(i in 0 until n) {
            val nextDp = mutableMapOf<Int, Int>()
            for((total, count) in dp) {
                nextDp[total + nums[i]] = nextDp.getOrDefault(total 
                + nums[i], 0) + count

                nextDp[total - nums[i]] = nextDp.getOrDefault(total 
                - nums[i], 0) + count
            }
            dp.clear()
            dp.putAll(nextDp)
        }

        return dp[target] ?: 0
    }
}
