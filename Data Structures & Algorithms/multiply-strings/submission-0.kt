class Solution {
    fun multiply(num1: String, num2: String): String {

        if("0" in listOf(num1, num2)) {
            return "0"
        }
        val res = IntArray(num1.length + num2.length)

        for(i1 in num1.indices.reversed()) {
            for(i2 in num2.indices.reversed()) {
                val pos = (num1.length - 1 - i1) + (num2.length - 1 - i2)

                val digit = (num1[i1] - '0') * (num2[i2] - '0')

                res[pos] += digit
                res[pos+1] += res[pos] / 10
                res[pos] = res[pos] % 10
            }
        }

        var start = res.size - 1
        while(start >= 0 && res[start] == 0) {
            start--
        }

        if(start < 0) {
            return "0"
        }

        return buildString {
            for(i in start downTo 0) {
                append(res[i])
            }
        }
    }
}
