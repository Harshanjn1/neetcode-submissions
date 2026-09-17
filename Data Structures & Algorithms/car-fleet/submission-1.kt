class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.indices.map {
            i -> position[i] to speed[i]
        }.sortedByDescending{it.first}
        val stack = mutableListOf<Double>()

        for((p, s) in pair) {
            val time = (target - p).toDouble() / s
            stack.addLast(time)
            if(stack.size >= 2 && stack.last() <= stack[stack.size - 2] ) {
                stack.removeLast()
            }
        }
        return stack.size
    }
}
