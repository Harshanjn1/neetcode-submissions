class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0),
        intArrayOf(0, 1), intArrayOf(0, -1))

        val rows = grid.size
        val cols = grid[0].size
        var area = 0

        fun bfs(r: Int, c: Int): Int {
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(r to c)
            grid[r][c] = 0
            var res = 1

            while(queue.isNotEmpty()) {
                val (i, j) = queue.removeFirst()
                for(dir in directions) {
                    val row = i + dir[0]
                    val col = j + dir[1]
                    if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
                        continue
                    }

                    queue.add(Pair(row, col))
                    grid[row][col] = 0
                    res++
                }
            }
            return res
        }

        for(i in 0 until rows) {
            for(j in 0 until cols) {
                if(grid[i][j] == 1) {
                    area = max(area, bfs(i,j))
                }
            }
        }
        return area
    }
}
