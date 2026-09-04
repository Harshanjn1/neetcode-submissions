class Solution {
    fun trap(height: IntArray): Int {
        var res = 0
        var l = 0
        var r = height.size - 1
        var leftMax = height[l]
        var rightMax = height[r]
        while(l < r) {
            // we only care about lowest value from right and 
            // left side. 
            if(leftMax < rightMax) {
                l++
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            } else {
                r--
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
            }
        }
        return res
    }
}
