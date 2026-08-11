class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>{ a, b ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        }
        for(point in points) {
            maxHeap.add(point)
            if(maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        return Array(k) {maxHeap.poll()}
    }
}
