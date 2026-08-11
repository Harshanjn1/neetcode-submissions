/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        intervals.sortedBy {
            it.start
        }. let { intervals ->
            for(i in 1 until intervals.size) {
                if(intervals[i-1].end > intervals[i].start) return false
            }
        }
        return true
    }
}
