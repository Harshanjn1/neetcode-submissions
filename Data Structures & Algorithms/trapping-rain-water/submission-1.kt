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
        for(i in 1 until size) {
            leftMax[i] = max(leftMax[i - 1], height[i - 1])
        }

        for (i in size - 2 downTo 0) {
            rightMax[i] = max(rightMax[i+1], height[i+1])
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
