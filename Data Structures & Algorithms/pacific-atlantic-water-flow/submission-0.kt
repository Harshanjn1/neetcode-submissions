class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val pac = HashSet<Pair<Int, Int>>()
        val atl = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, visit: HashSet<Pair<Int, Int>>, prevHeight: Int) {
            if(Pair(r, c) in visit || r !in 0 until rows || c !in 0 until cols
            || heights[r][c] < prevHeight) {
                return 
            }
            visit.add(Pair(r, c))

            dfs(r + 1, c, visit, heights[r][c])
            dfs(r - 1, c, visit, heights[r][c])
            dfs(r, c + 1, visit, heights[r][c])
            dfs(r, c - 1, visit, heights[r][c])
        }

        for (c in 0 until cols) {
            dfs(0, c, pac, heights[0][c])
            dfs(rows - 1, c , atl, heights[rows-1][c])
        }

        for(r in 0 until rows) {
            dfs(r, 0, pac, heights[r][0])
            dfs(r, cols-1, atl, heights[r][cols-1])
        }

        val res = mutableListOf<List<Int>>()

        for (r in 0 until rows) {
            for(c in 0 until cols) {
                if(Pair(r, c) in pac && Pair(r, c) in atl) {
                    res.add(listOf(r, c))
                }
            }
        }

        return res
    }
}
