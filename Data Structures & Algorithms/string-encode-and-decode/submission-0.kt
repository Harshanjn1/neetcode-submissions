class Solution {

    fun encode(strs: List<String>): String {
        val stringBuilder = StringBuilder()
        for(str in strs) {
            stringBuilder.append(str.length).append('#').append(str)
        }
        return stringBuilder.toString()
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()

        var i = 0
        while (i < str.length){
            var j = i

            while (str[j] != '#') {
                j++
            }

            val len = str.substring(i, j).toInt()

            res.add(str.substring(j + 1, j+1+len))
            i = (j + 1 + len) 
        }

        return res
    }
}
