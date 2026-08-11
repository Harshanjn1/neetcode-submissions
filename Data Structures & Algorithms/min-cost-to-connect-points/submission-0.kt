class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        // build adjacency list containing a node and their neighbours with edges weght
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()

        val n = points.size
        for(i in 0 until n) {
            val (x1, y1) = points[i]
            for(j in i + 1 until n) {
                val (x2, y2) = points[j]
                val dist  = abs(x1 - x2) + abs(y1 - y2)
                adj.getOrPut(i){mutableListOf<Pair<Int, Int>>()}.add(dist to j)
                adj.getOrPut(j){mutableListOf<Pair<Int, Int>>()}.add(dist to i)
            }
        }

        var res = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy {it.first})
        minHeap.add(0 to 0)
        val visited = mutableSetOf<Int>()

        while(visited.size < n) {
            val (cost, node) = minHeap.poll()
            if(node in visited) continue
            visited.add(node)
            res+= cost

            for((neiCost, nei) in adj[node] ?: emptyList()) {
                if(nei !in visited) {
                    minHeap.add(neiCost to nei)
                }
            }
        }

        return res
    }
}
