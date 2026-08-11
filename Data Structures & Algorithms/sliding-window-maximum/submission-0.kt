class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<Pair<Int,Int>>(compareByDescending{it.first})
        val res = mutableListOf<Int>()
        for((i , num) in nums.withIndex()) {
            heap.add(Pair(num, i))

            if(i >= k - 1) {
                while(heap.peek().second <= i - k) {
                    heap.poll()
                }

                res.add(heap.peek().first)
            }
        }

        return res.toIntArray()
    }
}
