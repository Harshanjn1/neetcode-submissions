class Solution {
    fun longestPalindrome(s: String): String {
        // DP solution
        val n = s.length
        var resIndex = 0
        var resLen = 0

        val dp = Array(n) {BooleanArray(n)}

        for(i in n-1 downTo 0) {
            for(j in i until n) {
                if(s[i] == s[j] && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true
                    if(j - i + 1 > resLen) {
                        resLen = j - i + 1
                        resIndex = i
                    }
                }
            }
        }

        return s.substring(resIndex, resIndex + resLen)
    }
}
