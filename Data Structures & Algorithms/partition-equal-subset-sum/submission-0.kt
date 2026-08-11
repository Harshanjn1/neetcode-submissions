class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if(sum % 2 != 0) return false

        val target = sum / 2
        val len = nums.size

        val dp = Array(len + 1) {BooleanArray(target + 1)}

        for(i in 0..len) {
            dp[i][0] = true
        }

        for(i in 1..len) {
            for(j in 1..target) {
                dp[i][j] = if(nums[i-1] <= j) {
                    dp[i-1][j] || dp[i-1][j - nums[i-1]]
                } else {
                    dp[i-1][j]
                }
            }
        }

        return dp[len][target]
    }
}
