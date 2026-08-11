class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        val res = IntArray(temperatures.size)

        for(i in temperatures.indices) {
        
            while(stack.isNotEmpty() && temperatures[stack[stack.size - 1]] < temperatures[i]) {
                val topIndex = stack.removeLast()
                res[topIndex] = i - topIndex
            }
            stack.add(i)
        }

        return res
    }
}
