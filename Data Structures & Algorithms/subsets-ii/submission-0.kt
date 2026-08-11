class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val subSet = mutableListOf<Int>()
        nums.sort()
        fun dfs(i: Int) {
            if(i == nums.size) {
                res.add(subSet.toList())
                return
            }

            subSet.add(nums[i])
            dfs(i+1)
            subSet.removeLast()
            var next = i + 1
            while(next < nums.size && nums[next] == nums[i]) {
                next++
            }
            dfs(next)
        }
        dfs(0)
        return res
    }
}
