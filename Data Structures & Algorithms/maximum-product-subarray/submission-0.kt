class Solution {
    fun maxProduct(nums: IntArray): Int {
        var res = nums[0]
        var curMin = 1
        var curMax = 1
        for(num in nums) {
            val temp = curMax * num
            curMax = max(temp, max(curMin*num, num))
            curMin = min(temp, min(curMin*num, num))
            res = max(res, curMax)
        }
        return res
    }
}
