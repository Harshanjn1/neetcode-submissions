class Solution {
    fun trap(height: IntArray): Int {
        if(height.isEmpty()) return 0
        var l = 0
        var r = height.size - 1
        var leftMax = height[0]
        var rightMax = height[r]
        var res = 0
        while(l < r) {
            if(leftMax < rightMax) {
                l++
                leftMax= max(leftMax, height[l])
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
