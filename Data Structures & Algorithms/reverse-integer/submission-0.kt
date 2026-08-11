class Solution {
    fun reverse(x: Int): Int {
        var res = 0
        var num = x
        val MIN = Int.MIN_VALUE
        val MAX = Int.MAX_VALUE
        while (num != 0) {
            val digit = (num % 10)
            num /= 10

            if(res > MAX / 10  || (res == MAX && digit > MAX % 10) ) {
                return 0
            }

            if(res < MIN / 10  || (res == MIN && digit < MIN % 10) ) {
                return 0
            }

            res = res * 10 + digit
        }
        return res
    }
}
