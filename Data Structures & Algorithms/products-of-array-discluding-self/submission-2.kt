class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val len = nums.size
        val prefix = IntArray(len)
        val suffix = IntArray(len)
        val res = IntArray(len)

        prefix[0] = 1
        suffix[len - 1] = 1
        for(i in 1 until len) {
            prefix[i] = prefix[i-1] * nums[i - 1]
        }

        for(i in len- 2 downTo 0) {
            suffix[i] = suffix[i+1] * nums[i + 1]
        }

        for(i in 0 until len) {
            res[i] = prefix[i] * suffix[i]
        }

        return res

    }
}
