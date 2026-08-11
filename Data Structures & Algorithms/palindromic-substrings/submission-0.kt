class Solution {
    fun countSubstrings(s: String): Int {
        // DP solution
        val n = s.length
        var res = 0

        val dp = Array(n) {BooleanArray(n)}

        for(i in n-1 downTo 0) {
            for(j in i until n) {
                if(s[i] == s[j] && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true
                    res++
                }
            }
        }

        return res
    }
}
