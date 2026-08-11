class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val len = digits.size
        for(i in len - 1 downTo 0) {
            if(digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        return intArrayOf(1) + digits
    }
}
