class Solution {
    fun climbStairs(n: Int): Int {
        if(n <= 2) return n
        var prev = 2
        var prev2 = 1

        for(i in 3..n) {
            val temp = prev
            prev = prev + prev2
            prev2 = temp
        }
        return prev
    }
}
