class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hashSet = nums.toSet()
        var res = 0
        for(num in nums) {
            var streak = 0
            if(num - 1 !in hashSet) {
                while(num + streak in hashSet) {
                    streak++
                }
            }
            res = max(streak, res)
        }
        return res
    }
}
