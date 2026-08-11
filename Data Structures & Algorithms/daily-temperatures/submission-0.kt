class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        val res = IntArray(temperatures.size)

        for(i in temperatures.indices) {
        
            while(stack.isNotEmpty() && temperatures.get(stack[stack.size - 1]) < temperatures.get(i)) {
                val topIndex = stack.get(stack.size - 1)
                res[topIndex] = i - topIndex
                stack.removeLast()
            }
            stack.add(i)
        }

        return res
    }
}
