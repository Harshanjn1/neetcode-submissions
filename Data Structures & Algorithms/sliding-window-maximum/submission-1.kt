class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<Pair<Int,Int>>(compareByDescending{it.first})
        val res = IntArray(nums.size - k + 1)
        for((i , num) in nums.withIndex()) {
            heap.add(Pair(num, i))

            if(i >= k - 1) {
                while(heap.peek().second <= i - k) {
                    heap.poll()
                }

                res[i - k + 1] = heap.peek().first
            }
        }

        return res
    }
}
