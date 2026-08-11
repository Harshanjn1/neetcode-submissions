/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val start = intervals.map {it.start}.sorted()
        val end = intervals.map{it.end}.sorted()

        var s = 0
        var e = 0
        var count = 0//number meeting rooms currently occupied
        var res = 0

        while(s < intervals.size) {
            if(start[s] < end[e]) {
                // occupy the meeting room
                s++
                count++
            } else {
                //release the meeting room
                e++
                count--
            }
            res= max(res, count)
        }
        return res
    }
}
