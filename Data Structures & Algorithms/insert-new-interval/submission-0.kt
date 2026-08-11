class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
      
        for(i in  intervals.indices) {
            // when the new interval comes before the interval starts there is no overlap
            if(newInterval[1] < intervals[i][0]) {
                res.add(newInterval)
                return (res + intervals.sliceArray(i until intervals.size)).toTypedArray()
            } else if(newInterval[0] > intervals[i][1]) {
                // new interval comes after the current interval , no overlap just add 
                //new interval to the result
                res.add(intervals[i])
            } else {
                // merge scenario
                newInterval[0] = min(newInterval[0], intervals[i][0])
                newInterval[1] = max(newInterval[1], intervals[i][1])
            }
        }
        res.add(newInterval)
        return res.toTypedArray()
    }
}
