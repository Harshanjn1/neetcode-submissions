class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for((index, value) in nums.withIndex()) {
            if(map.contains(target - value)) {
                return intArrayOf(map[target - value]!!, index)
            }
            map[value] = index
        }
        return intArrayOf(-1 , -1)
    }
}
