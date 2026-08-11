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
        val dp = Array(n+1) {mutableMapOf<Int, Int>()}

        dp[0][0] = 1

        for(i in 0 until n) {
            for((total, count) in dp[i]) {
                dp[i+1][total + nums[i]] = dp[i+1].getOrDefault(total 
                + nums[i], 0) + count

                dp[i+1][total - nums[i]] = dp[i+1].getOrDefault(total 
                - nums[i], 0) + count
            }
        }

        return dp[n][target] ?: 0
    }
}
