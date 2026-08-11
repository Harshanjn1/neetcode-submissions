class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        // to store index and height values that we can extend
        val stack = mutableListOf<Pair<Int, Int>>()

        for((i, h) in heights.withIndex()) {
            var start = i
            while(stack.isNotEmpty() && stack.last().second > h) {
                // current height is less than the previous histogram stores in the stack
                // hence pop the previuos histogram

                val top = stack.removeLast()
                maxArea = max(maxArea, top.second * (i - top.first))
                start = top.first
            }
            stack.addLast(Pair(start, h))
        }


        for(pair in stack) {
            maxArea = max(maxArea, pair.second * (heights.size - pair.first))
        }

        return maxArea
    }
}
