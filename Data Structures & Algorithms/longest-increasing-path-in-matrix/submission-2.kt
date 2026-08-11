class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val dir = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0),
        intArrayOf(0, -1), intArrayOf(0, 1))

        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m) { IntArray(n) }

        fun dfs(r: Int, c: Int, prevVal: Int): Int {
            if(r !in 0 until m || c !in 0 until n || matrix[r][c] <= prevVal) {
                return 0
            }

            if(dp[r][c] != 0) return dp[r][c]

            var res = 1
            for(d in dir) {
                res = max(res, 1 + dfs(r+d[0], c+d[1], matrix[r][c]))
            }
            dp[r][c] = res

            return res
        }

        var LIP = 0
        for(r in 0 until m) {
            for(c in 0 until n) {
                LIP = max(LIP, dfs(r, c , -1))
            }
        }

        return LIP
    }
}
