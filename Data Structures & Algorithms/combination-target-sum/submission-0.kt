class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if(total == target) {
                res.add(cur.toList())
                return
            }

            if(i >= nums.size || total > target) {
                return
            }

            subset.add(nums[i])
            dfs(i, subset, total + nums[i])

            subset.removeLast()
            dfs(i+1, subset, total)
        }
        dfs(0, mutableListOf<Int>(), 0)
        return res
    }
}
