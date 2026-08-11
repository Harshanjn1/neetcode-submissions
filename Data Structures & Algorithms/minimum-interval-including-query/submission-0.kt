class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy {it[0]}

        val queriesWithIndex = queries.withIndex()
        .map{it.value to it.index}
        .sortedBy{it.first}

        var i = 0
        val res = IntArray(queries.size)

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy{it.first})

        for((q, index) in queriesWithIndex) {
            // add the intervals to the minHeap which contains query point
            while(i < intervals.size && intervals[i][0] <= q) {
                minHeap.add((intervals[i][1] - intervals[i][0] + 1) to intervals[i][1])
                i++
            }

            // now remove the interval which doesnt contain the query value
            while(minHeap.isNotEmpty() && minHeap.peek().second < q) {
                minHeap.poll()
            }

            res[index] = if(minHeap.isNotEmpty()) minHeap.peek().first else -1
        }
        return res
    }
}
