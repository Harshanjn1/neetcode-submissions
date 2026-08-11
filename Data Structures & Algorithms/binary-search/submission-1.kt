class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val m = l + (r - l) / 2 // avoid integer overflow
            when {
                nums[m] > target -> r = m - 1
                nums[m] < target -> l = m + 1
                else -> return m
            }
        }

        return -1
        
        
    }
}
