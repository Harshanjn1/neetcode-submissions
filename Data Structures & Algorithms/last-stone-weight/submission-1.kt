class Solution {
    fun lastStoneWeight(stones: IntArray): Int {

        val maxHeap = PriorityQueue<Int>(compareByDescending{it})

        for(num in stones) {
            maxHeap.add(num)
        }

        while(maxHeap.size > 1) {
            val max1 = maxHeap.poll()
            val max2 = maxHeap.poll()

            if(max1 != max2) {
                maxHeap.add(max1 - max2)
            }
        }

        return if(maxHeap.isNotEmpty()) return maxHeap.peek() else return 0

    }
}
