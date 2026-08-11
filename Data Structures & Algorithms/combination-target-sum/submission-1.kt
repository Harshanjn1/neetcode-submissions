class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if(total == target) {
                res.add(cur.toList())
                return
            }

            if(i >= nums.size || total > target) {
                return
            }

            cur.add(nums[i])
            dfs(i, cur, total + nums[i])

            cur.removeLast()
            dfs(i+1, cur, total)
        }
        dfs(0, mutableListOf<Int>(), 0)
        return res
    }
}
