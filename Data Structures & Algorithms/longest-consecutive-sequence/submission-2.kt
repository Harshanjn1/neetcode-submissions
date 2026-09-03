class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var res = 0

        for(num in nums) {
            // if a number is processed , we can skip the duplicate one
            if(map[num] == null) {
                val left = map[num-1] ?: 0
                val right = map[num+1] ?: 0
                val sum = left + right + 1

                map[num] = sum
                map[num - left] = sum
                map[num + right] = sum
                res = max(res, sum)
            }
            
        }
        return res
    }
}
