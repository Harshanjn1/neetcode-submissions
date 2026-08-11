class CountSquares {

    // hashmap to store the count of the duplicate points
    val ptCounts = HashMap<Pair<Int, Int>, Int>()

    val points = mutableListOf<IntArray>() 

    fun add(point: IntArray) {
        val key = Pair(point[0], point[1])
        ptCounts[key] = ptCounts.getOrDefault(key, 0) + 1
        points.add(point)

    }

    fun count(point: IntArray): Int {
        // lets take point as a py and px and search for x and y which is diagonal to px and py
        var result = 0
        val (px, py) = point
        for((x, y) in points) {
            if(Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                // not a diagonal co-ordinates
                continue
            }
            // now search for other diagonal co-ordinates which are (x, py) and (y, px)
            result += (ptCounts[Pair(x, py)] ?: 0) * (ptCounts[Pair(px, y)] ?: 0)
        }
        return result
    }
}
