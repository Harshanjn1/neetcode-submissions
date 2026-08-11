class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        fun dfs(index: Int) {
            if(index >= nums.size) {
                res.add(subset.toList())
                return
            }

            subset.add(nums[index])
            dfs(index + 1)
            subset.removeLast()
            dfs(index + 1)
        }
        dfs(0)
        return res
    }
}
