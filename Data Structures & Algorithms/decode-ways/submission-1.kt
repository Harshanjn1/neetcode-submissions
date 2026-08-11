class Solution {
    fun numDecodings(s: String): Int {
        // val dp = HashMap<Int, Int>()
        // dp[s.length] = 1
        // fun recursion(i: Int): Int {
        //     if(i in dp.keys) {
        //         return dp[i]!!
        //     }
        //     if(i == s.length) {
        //         return 1
        //     }

        //     if(s[i] == '0') return 0

        //     var res = recursion(i+1)
        //     if(i < s.length - 1) {
        //         if(s[i] == '1' || (s[i] == '2' && s[i+1] < '7')) {
        //             res += recursion(i+2)
        //         }
        //     }
        //     dp[i] = res
        //     return res
        // }

        // return recursion(0)

        //Tabulation
        val n = s.length
        var dp = 0//final result
        var dp1 = 1 // dp[i+1]
        var dp2 = 0 // dp[i+2]
        for(i in n - 1 downTo 0) {
            if(s[i] == '0') {
                dp = 0
            } else {
                if(i < n) {
                    dp = dp1
                }

                if(i < n - 1 && (s[i] == '1' || (s[i] == '2' && s[i+1] < '7'))) {
                    dp += dp2
                }
            }
            dp2 = dp1
            dp1 = dp

        }
        return dp
    }
}
