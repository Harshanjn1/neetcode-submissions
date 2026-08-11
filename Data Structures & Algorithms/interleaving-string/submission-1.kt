class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val m = s1.length 
        val n = s2.length 
        // val dp = Array(m+1) {IntArray(n+1) {-1}}
        // fun recursion(i: Int, j: Int, k: Int): Boolean {
        //     if(k == s3.length) {
        //         return (i == m && j == n)
        //     }

        //     if(dp[i][j] != -1) {
        //         return dp[i][j] == 1
        //     }

        //     var res = false

        //     if(i < m && s1[i] == s3[k]) {
        //         res = recursion(i+1, j, k+1)
        //     }

        //     if(!res && j < n && s2[j] == s3[k]) {
        //         res = recursion(i, j+1, k+1)
        //     }


        //     dp[i][j] = if(res) 1 else 0

        //     return res
        // }

        // return recursion(0,0,0)


        // Bottom - Up Approach
        //----------------------------

        if(m + n != s3.length) return false
        val dp = Array(m+1) {BooleanArray(n+1)}
        dp[m][n] = true

        for(i in m downTo 0) {
            for(j in n downTo 0) {
                if(i < m && s1[i] == s3[i+j] && dp[i+1][j]) {
                    dp[i][j] = true
                }

                if(j < n && s2[j] == s3[i+j] && dp[i][j+1] == true) {
                    dp[i][j] = true
                }
            }
        }

        return dp[0][0]
    }
}
