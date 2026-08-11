class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val size = grid.size
        val dir = listOf(Pair(0,1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))

        val minHeap = PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy{it.first})

        minHeap.add(Pair(grid[0][0], Pair(0,0)))
        val visit = HashSet<Pair<Int, Int>>()
        visit.add(Pair(0,0))

        while(minHeap.isNotEmpty()) {
            val (time, pos) = minHeap.poll()
            val (r, c) = pos

            if(r == size - 1 && c == size - 1) return time
            for((dr, dc) in dir) {
                val neiR = r + dr
                val neiC = c + dc
                if(neiR !in 0 until size || neiC !in 0 until size || Pair(neiR,neiC) in visit) continue
                visit.add(Pair(neiR,neiC))
                minHeap.offer(Pair(max(time, grid[neiR][neiC]), Pair(neiR,neiC)))
            
            }
        }
        return -1
    }
}