class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var curSum = 0

        for(num in nums) {
            if(curSum < 0) curSum = 0
            curSum += num

            maxSum = max(curSum, maxSum)
        }
        return maxSum
    }
}
