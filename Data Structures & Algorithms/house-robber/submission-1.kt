class Solution {
    fun rob(nums: IntArray): Int {
        // val n = nums.size
        // val dp = IntArray(n) {-1}
        // fun recursion(index: Int): Int {
        //     if(index >= n) return 0
        //     if(dp[index] != -1) return dp[index]
        //     dp[index] = max(recursion(index+1), (nums[index] + recursion(index+2)))
        //     return dp[index]
        // }
        // return recursion(0)

        // Bottom -up approach building the dp array 
        // based on the previous values

        // we will insert the maximum amount we can rob till index
        if (nums.isEmpty()) return 0
    
        // 2. Guard against single-element arrays
        if (nums.size == 1) return nums[0]
        var prev2 = nums[0]
        var prev = max(nums[0], nums[1])

        for(i in 2 until nums.size) {
            val temp = prev
            prev = max(prev, (nums[i] + prev2))
            prev2 = temp
        }
        return prev
    }
}
