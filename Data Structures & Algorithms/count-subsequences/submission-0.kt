class Solution {
    fun numDistinct(s: String, t: String): Int {
        val sl = s.length
        val tl = t.length
        if(tl > sl) return 0
        val dp = Array(sl) {IntArray(tl) {-1}}
        fun dfs(i: Int, j: Int): Int {
            if(j == tl) return 1

            if(i == sl) return 0

            if(dp[i][j] != -1) return dp[i][j]

            var res = dfs(i+1, j)
            if(s[i] == t[j]) {
                res += dfs(i+1, j+1) 
            } 
            dp[i][j] = res
            return res 
        }
        return dfs(0,0)
    }
}
