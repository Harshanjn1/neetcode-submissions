class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        candidates.sort()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if(total == target) {
                res.add(cur.toList())
                return
            }
            if(i >= candidates.size || total > target) {
                return
            }
            cur.add(candidates[i])
            dfs(i + 1, cur, total + candidates[i])
            cur.removeLast()
            var next = i + 1
            while(next < candidates.size && candidates[next] == candidates[i]) {
                next++
            }
            dfs(next, cur, total)
        }

        dfs(0, mutableListOf<Int>(), 0)
        return res
    }
}
