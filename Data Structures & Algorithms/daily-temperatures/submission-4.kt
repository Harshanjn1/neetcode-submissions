class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size) {0}
        val stack = ArrayDeque<Int>()

        for(i in temperatures.indices) {
            while(stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                res[stack.last()] = i - stack.removeLast()
            }

            stack.addLast(i)
        }
        return res
    }
}
