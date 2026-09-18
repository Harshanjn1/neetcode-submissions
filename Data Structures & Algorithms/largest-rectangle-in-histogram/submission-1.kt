class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Pair<Int, Int>>()

        heights.forEachIndexed { i, h ->
            var start = i
            while(stack.isNotEmpty() && h < stack.last().second) {
                val (index, height) = stack.removeLast()
                maxArea = max(maxArea, height * (i - index))
                start = index
            }
            stack.addLast(start to h)
        }

        val n = heights.size
        for((i, h) in stack) {
            maxArea = max(maxArea, h * (n - i))
        }
        return maxArea
    }
}
