class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length 
        val n = word2.length
        // val dp = Array(m) { IntArray(n) {-1}}

        // // i - word1 index, j - word2.length 
        // fun dfs(i: Int, j: Int): Int {
        //     if(j == n) return m - i
        //     if(i == m) return n - j

        //     if(dp[i][j] != -1) return dp[i][j]
            
        //     dp[i][j] = if(word1[i] == word2[j]) {
        //        dfs(i+1, j+1)
        //     } else {
        //         val insert = dfs(i, j+1)
        //         val delete = dfs(i+1, j)
        //         val replace = dfs(i+1, j+1)
        //         1 + minOf(insert, delete , replace)
        //     }
        //     return dp[i][j]
        // }
        // return dfs(0,0)

        // Bottom-Up Approach
        //----------------------------

        //val dp = Array(m+1) {IntArray(n+1)}

        val dp = IntArray(n+1)
        val nextdp = IntArray(n+1)
        for(j in 0..n) {
            dp[j] = n-j
        }
        // for(i in 0..m) {
        //     dp[i][n] = m-i
        // }

        for(i in m-1 downTo 0) {
            nextdp[n] = m - i
            for(j in n-1 downTo 0) {
                nextdp[j] = if(word1[i] == word2[j]) {
                    dp[j+1]
                } else {
                    1+ minOf(dp[j], dp[j+1], nextdp[j+1])
                }
            }
            dp.indices.forEach{dp[it] = nextdp[it]}
        }

        return dp[0]
    }
}
