class Solution {
    fun missingNumber(nums: IntArray): Int {
        val size = nums.size
        var res = size
        for(i in 0 until size) {
            res = res xor i xor nums[i]
        }
        return res
    }
}
