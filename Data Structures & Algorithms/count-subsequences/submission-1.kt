class Solution {
    fun numDistinct(s: String, t: String): Int {
        val sl = s.length
        val tl = t.length
        if(tl > sl) return 0
        // val dp = Array(sl) {IntArray(tl) {-1}}
        // fun dfs(i: Int, j: Int): Int {
        //     if(j == tl) return 1

        //     if(i == sl) return 0

        //     if(dp[i][j] != -1) return dp[i][j]

        //     var res = dfs(i+1, j)
        //     if(s[i] == t[j]) {
        //         res += dfs(i+1, j+1) 
        //     } 
        //     dp[i][j] = res
        //     return res 
        // }
        // return dfs(0,0)

        // Bottom Up approach
        //------------------------

        var dp = IntArray(tl+1)
        dp[tl]= 1        
        // for(i in 0..sl) {
        //     dp[i][tl] = 1// there is one way to match an empty string t , that is not opting 
        //     // any string from s
        // }

        for(i in sl-1 downTo 0) {
            val nextdp = IntArray(tl+1)
            nextdp[tl] = 1
            for (j in tl-1 downTo 0) {
                nextdp[j] += dp[j]
                if(s[i] == t[j]) {
                    nextdp[j] += dp[j+1]
                }
            }
            dp = nextdp
        }
        return dp[0]
    }
}
