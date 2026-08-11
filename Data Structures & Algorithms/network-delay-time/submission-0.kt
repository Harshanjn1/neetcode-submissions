class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val edges = HashMap<Int, MutableList<Pair<Int, Int>>>()

        // build the adjacency list using the input
        for((u, v, t) in times) {
            edges.getOrPut(u) {mutableListOf<Pair<Int, Int>>()}.add(Pair(v, t))
        }

        // create a set to keep track of all the visited node
        val visit = HashSet<Int>()
        // create a min heap to find the next min path node to explore 
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy{it.first})
        // adding first source node to the heap
        minHeap.offer(Pair(0, k))
        // res variable, total time taken to reach all the network node
        var t = 0

        while(minHeap.isNotEmpty()) {
            val (time, n) = minHeap.poll()

            if(n in visit) continue
            visit.add(n)
            t = time

            edges[n]?.forEach{ (nextNode, weight) ->
                if(nextNode !in visit) {
                    minHeap.offer(Pair(t + weight, nextNode))
                }
            }
        }

        return if(visit.size == n) t else -1
    }
}
