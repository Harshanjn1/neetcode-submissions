class MedianFinder {

    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(compareByDescending{it})

    fun addNum(num: Int) {
        if(minHeap.isNotEmpty() && num > minHeap.peek()) {
            minHeap.add(num)
        } else {
            maxHeap.add(num)
        }

        // Rebalance the heaps
        if(minHeap.size > maxHeap.size + 1) {
            maxHeap.add(minHeap.poll())
        }

        if(maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        }
    }

    fun findMedian(): Double {
        return when {
            minHeap.size > maxHeap.size -> minHeap.peek().toDouble()
            maxHeap.size > minHeap.size -> maxHeap.peek().toDouble()
            else -> (minHeap.peek() + maxHeap.peek()) / 2.0
        }
    }
}
