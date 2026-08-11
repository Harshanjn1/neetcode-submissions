class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // prev = -1 indicates starting of the dfs
        val len = nums.size
        //Top down approach
        //---------------------------------------
        // val dp = Array(len + 1) {IntArray(len + 1) { -1 }}
        // fun dfs(cur: Int, prev: Int): Int {
        //     if(cur == len) return 0
        //     if(dp[cur][prev+1] != -1) return dp[cur][prev+1]

        //     var LIS = dfs(cur + 1, prev) // dont include the i in the sequesnce
        //     if(prev == -1 || nums[prev] < nums[cur]) {
        //         LIS = max(LIS, 1 + dfs(cur+1, cur)) //include
        //     }
        //     dp[cur][prev+1] = LIS 
        //     return LIS
        // }

        // return dfs(0, -1)
        // Bottom-Up Approach
        // ---------------------------------------------------

        val dp = Array(len + 1) { IntArray(len + 1) }

        for(i in len - 1 downTo 0) {
            for (j in i - 1 downTo -1) {
                var LIS = dp[i+1][j+1] // dont include i

                if(j == -1 || nums[j] < nums[i]) {
                    LIS = max(LIS, 1 + dp[i+1][i+1])
                }
                dp[i][j+1] = LIS
            }
        }

        return dp[0][0]
    }
}
