class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var fresh = 0
        var time = 0
        val queue = ArrayDeque<Pair<Int, Int>>()

        for(i in 0 until rows) {
                for(j in 0 until cols) {
                        if(grid[i][j] == 1) {
                                fresh++
                        }
                        if(grid[i][j] == 2) {
                                queue.addLast(Pair(i, j))
                        }
                }
        }

        val directions = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, -1),
                intArrayOf(1, 0),
                intArrayOf(-1, 0)
        )

        while(fresh > 0 && queue.isNotEmpty()) {
                val len = queue.size
                repeat(len) {
                        val (r, c) = queue.poll()

                        for(dir in directions) {
                                val nr = r + dir[0]
                                val nc = c + dir[1]

                                if(nr in 0 until rows && nc in 0 until cols && grid[nr][nc] == 1 ) {
                                        grid[nr][nc] = 2
                                        queue.addLast(Pair(nr, nc))
                                        fresh--
                                }
                        }

                }
                time++
        }

        return if(fresh == 0) time else -1
    }
}
