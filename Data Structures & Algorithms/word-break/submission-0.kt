class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // Top-Down Approach
        //-------------------------------------------------------
        // val len = s.length
        // val memoMap = HashMap<Int, Boolean>()
        // memoMap[len] = true
        // fun recursion(i: Int): Boolean {
        //     memoMap[i]?.let { return it }
        //     if(i == len) return true
        //     for(word in wordDict) {
        //         if(len - i >= word.length && 
        //         s.substring(i, i + word.length) == word) {
        //             if(recursion(i + word.length))  {
        //                 memoMap[i] = true
        //                 return true 
        //             }
        //         }
        //     }
        //     memoMap[i] = false
        //     return false
        // }

        // return recursion(0)

        // Bottom-Up Approach
        // ---------------------------------------------------
        val len = s.length
        val dp = BooleanArray(len + 1) 
        dp[len] = true

        for(i in len - 1 downTo 0) {
            for (word in wordDict) {
                if(i + word.length <= len && s.substring(i, i + word.length) == word) {
                    dp[i] = dp[i + word.length]
                }
                if(dp[i]) break
            }
        }

        return dp[0]
    }

}
