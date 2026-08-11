class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)
        for(task in tasks) {
            count[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending{it})

        for(c in count) {
            if(c > 0) {
                maxHeap.add(c)
            }
        }

        // stores pair of element to process and next available time after cooling time.
        val q = ArrayDeque<Pair<Int, Int>>()
        var time = 0
        while(maxHeap.isNotEmpty() || q.isNotEmpty()) {
            time++
            // there is no item to process lets take from cooling queue by updating
            // the time to next available time.
            if(maxHeap.isEmpty()) {
                time = q.first().second
            } else {
                val cnt = maxHeap.poll() - 1
                if(cnt > 0) {
                    q.addLast(Pair(cnt, time + n))
                }
            }

            if(q.isNotEmpty() && q.first().second == time) {
                maxHeap.add(q.removeFirst().first)
            }
        }

        return time
    }
}
