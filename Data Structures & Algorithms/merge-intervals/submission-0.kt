class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy{it[0]}
        val res = mutableListOf<IntArray>()

        // by default append the first input
        res.add(intervals[0])

        // iterate throught the input array and and check for 
        // interval overlap with the neighbouring co-ordinates
        for(i in 1 until intervals.size) {
            val lastEnd = res.last()[1]
            if(intervals[i][0] <= lastEnd) {
                // we found the overlapping
                res[res.size - 1][1] = max(lastEnd, intervals[i][1])
            } else {
                res.add(intervals[i])
            }
        }

        return res.toTypedArray()
    }
}
