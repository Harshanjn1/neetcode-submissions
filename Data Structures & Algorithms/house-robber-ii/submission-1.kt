class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]

        return max(helper(nums.sliceArray(0..nums.size - 2)),
        helper(nums.sliceArray(1..nums.size-1)))
    }

    private fun helper(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var rob1 = nums[0]
        var rob2 = max(nums[1], nums[0])

        for(i in 2 until nums.size) {
            val temp = max(nums[i] + rob1, rob2)
            rob1 = rob2
            rob2 = temp
        }
        return rob2
    }
}
