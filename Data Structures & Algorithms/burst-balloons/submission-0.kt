class Solution {
    fun maxCoins(nums: IntArray): Int {
        val newNums = intArrayOf(1) + nums + intArrayOf(1)
        val n = nums.size
        // val dp = Array(n) { IntArray(n) }
        // fun recursion(l: Int, r: Int): Int {
        //     if(l > r) return 0
        //     if(dp[r][l] != 0 ) return dp[r][l]
        //     var ans = 0
        //     for (k in l+1 until r) {
        //         ans = max(ans, recursion(l, k) + 
        //         recursion(k, r) + (newNums[l] * newNums[r] * newNums[k]))
        //     }
        //     dp[r][l] = ans

        //     return ans
        // }

        // return recursion(0, newNums.size - 1)

        // Bottom-Up Approach
        //-----------------------------------------

        val dp = Array(n+2) { IntArray(n+2)}

        for(l in n downTo 1) {
            for (r in 1..n) {
                for (k in l..r) {
                    dp[l][r] = max(dp[l][r], dp[l][k-1] + 
                    dp[k+1][r] + (newNums[l-1] * newNums[r+1] * newNums[k]))
                }
            }
        }

        return dp[1][n]
    }
}
