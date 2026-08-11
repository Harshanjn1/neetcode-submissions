class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        // Top Down approach
        //---------------------------
        // val dp = Array(m+1) {IntArray(n+1) {0}}

        // dp[m-1][n-1] = 1 // there is exactly one way to reach
        // // final destination from this point i.e, to stay there

        // for(i in m-1 downTo 0) {
        //     for(j in n-1 downTo 0) {
        //         dp[i][j] += dp[i+1][j] + dp[i][j+1]
        //     }
        // }
        // return dp[0][0]

        // space optimised
        //-------------------------------------------

        var row = IntArray(n) {1}

        for(i in 0 until m-1) {
            val newRow = IntArray(n) {1}
            for(j in n-2 downTo 0) {
                newRow[j] = row[j] + newRow[j+1]
            }
            row = newRow
        }

        return row[0]
    }
}
