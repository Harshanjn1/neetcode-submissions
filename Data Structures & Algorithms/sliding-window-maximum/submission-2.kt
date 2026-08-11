class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        // using deque for most efficient solution o(n)

        val q = ArrayDeque<Int>()
        val res = IntArray(nums.size - k + 1)

        var l = 0
        var r = 0

        for((i , num) in nums.withIndex()) {
            while(q.isNotEmpty() && num > nums[q.last()]) {
                q.removeLast()
            }
            q.addLast(i)

            if(l > q.first()) {
                q.removeFirst()
            }

            if(i + 1 >= k) {
                res[i + 1 - k] = nums[q.first()]
                l++
            }
            r++
        }

        return res
        // val heap = PriorityQueue<Pair<Int,Int>>(compareByDescending{it.first})
        // val res = IntArray(nums.size - k + 1)
        // for((i , num) in nums.withIndex()) {
        //     heap.add(Pair(num, i))

        //     if(i >= k - 1) {
        //         while(heap.peek().second <= i - k) {
        //             heap.poll()
        //         }

        //         res[i - k + 1] = heap.peek().first
        //     }
        // }

        // return res
    }
}
