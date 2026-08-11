class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        // val top = cost.size
        // val dp = IntArray(top) {-1}
        // fun recursion(step: Int): Int {
        //     if(step >= top) return 0
        //     if(dp[step] != -1) return dp[step]

        //     dp[step] = cost[step] + min(recursion(step+1), 
        //     recursion(step+2))
        //     return dp[step]
        // }

        // return min(recursion(0), recursion(1))

        //-----------------------------
        // Bottom up approach
        val size = cost.size
        //val dp = IntArray(size + 1)
        var prev2 = 0
        var prev = 0

        for(i in 2..size) {
            val temp = prev
            prev = min((prev + cost[i-1]) , (prev2 + cost[i-2]))
            prev2 = temp
        }

        return prev
    }
}
