class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.zip(speed).sortedByDescending{it.first}
        val stack = mutableListOf<Double>()

        for((pos, speed) in pair){
            val time = (target - pos ).toDouble() / speed

            stack.add(time)
            if(stack.size >= 2 && stack[stack.size - 1] <= stack[stack.size - 2]) {
                stack.removeAt(stack.size - 1)
            }
        }

        return stack.size
    }
}
