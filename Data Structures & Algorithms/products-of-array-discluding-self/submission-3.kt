class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) {1}
        var prefix = 1
        for(i in nums.indices) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var postfix = 1
        for(i in nums.size - 1 downTo 0) {
            res[i] *= postfix
            postfix *= nums[i]
        }
        return res
    }
}
