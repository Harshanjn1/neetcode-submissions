class Solution {
    fun trap(height: IntArray): Int {
        val size = height.size
        var res = 0
        if(size <= 1) {
            return res
        }
        val leftMax = IntArray(size)
        val rightMax = IntArray(size)

        // to store maximum left number
        var left = 0
        leftMax[0] = left
        for(i in 1 until size) {
            left = max(left, height[i - 1])
            leftMax[i] = left
        }

        var right = 0
        rightMax[size - 1] = right
        for (i in size - 2 downTo 0) {
            right = max(right, height[i+1])
            rightMax[i] = right
        }

        // not find out the trapping rain water for every position
        for(i in 1 until size - 1) {
            val trappedWater = min(leftMax[i], rightMax[i]) - height[i]
            if(trappedWater > 0) {
                res += trappedWater
            } 
        }

        return res
    }
}
