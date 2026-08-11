class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hashSet = nums.toSet()
        var res = 0
        for (num in nums) {
             var length = 1
            if(num - 1 !in hashSet) {
                while (num + length in hashSet) {
                    length++
                }
                res = max(res, length)
            }
        }

        return res
    }
}
