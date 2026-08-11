class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(num in nums) {
            val index = Math.abs(num) - 1
            if(nums[index] < 0) {
                return Math.abs(num)
            }
            nums[index] *= -1
        }
        return -1
    }
}
