class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var res = 0
        intervals.sortBy{it[0]}
        var prevEnd = intervals[0][1]

        for(i in 1 until intervals.size) {
            val (start, end) = intervals[i]
            if(start >= prevEnd) {
                // there is no overlap jus
                prevEnd = end
            } else {
                res += 1
                prevEnd = min(prevEnd, end)
            }
        }

        return res
    }
}
