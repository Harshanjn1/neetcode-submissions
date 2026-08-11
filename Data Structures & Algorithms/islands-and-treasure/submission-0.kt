class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val m = grid.size
        val n = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()
        for(i in 0 until m) {
            for (j in 0 until n) {
                if(grid[i][j] == 0) {
                    queue.addLast(Pair(i, j))
                }
            }
        }

        if(queue.isEmpty()) return 
        val dir = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )

        while(queue.isNotEmpty()) {
            val (row, col) = queue.poll()

            for(di in dir) {
                val r = row + di[0]
                val c = col + di[1]

                if(r !in 0 until m || c !in 0 until n 
                || grid[r][c] != Int.MAX_VALUE) {
                    continue
                }

                queue.add(Pair(r, c))
                grid[r][c] = 1 + grid[row][col]
            }
        }
     }
}
