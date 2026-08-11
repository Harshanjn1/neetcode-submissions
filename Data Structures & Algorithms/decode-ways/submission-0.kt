class Solution {
    fun numDecodings(s: String): Int {
        val dp = HashMap<Int, Int>()
        dp[s.length] = 1
        fun recursion(i: Int): Int {
            if(i in dp.keys) {
                return dp[i]!!
            }
            if(i == s.length) {
                return 1
            }

            if(s[i] == '0') return 0

            var res = recursion(i+1)
            if(i < s.length - 1) {
                if(s[i] == '1' || (s[i] == '2' && s[i+1] < '7')) {
                    res += recursion(i+2)
                }
            }
            dp[i] = res
            return res
        }

        return recursion(0)
    }
}
