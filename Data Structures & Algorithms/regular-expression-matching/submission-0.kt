class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val dp = Array(m+1) {BooleanArray(n+1) {false}}
        // fun recursion(i: Int, j: Int): Boolean {
        //     if(j == n) return i == m
        //     if(dp[i][j]) return true
        //     val match = i < m && (s[i] == p[j] || p[j] == '.')

        //     if((j+1) < n && p[j+1] == '*') {
        //         return recursion(i, j+2) || (match && recursion(i+1, j))
        //     }

        //     dp[i][j] =  match && recursion(i+1, j+1)
        //     return dp[i][j]
        // }

        // return recursion(0,0)

        // Bottom-Up approach
        //----------------------------------

        dp[m][n] = true

        for(i in m downTo 0) {
            for(j in n-1 downTo 0) {
                val match = i < m && (s[i] == p[j] || p[j] == '.')

                dp[i][j] = if(j+1 < n && p[j+1] == '*') {
                    dp[i][j+2] || (match && dp[i+1][j])
                } else {
                    match && dp[i+1][j+1]
                } 
            }    
        }

        return dp[0][0]
    }
}
