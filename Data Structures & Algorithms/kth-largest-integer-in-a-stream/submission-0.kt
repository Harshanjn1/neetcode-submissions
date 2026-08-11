class KthLargest(k: Int, nums: IntArray) {

    private val priorityQueue = PriorityQueue<Int>()
    private val k = k

    init {

        for(num in nums) {
            priorityQueue.add(num)
        }

        while(priorityQueue.size > k) {
            priorityQueue.poll()
        }
        
    }

    fun add(`val`: Int): Int {
        priorityQueue.add(`val`)
        if(priorityQueue.size > k) {
            priorityQueue.poll()
        }
        return priorityQueue.peek()
    }
}
