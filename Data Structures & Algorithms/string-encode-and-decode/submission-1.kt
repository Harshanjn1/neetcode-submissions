class Solution {

    fun encode(strs: List<String>): String {
        val res = StringBuilder()
        for(str in strs) {
            res.append(str.length).append('#').append(str)
        }
        return res.toString()
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()
        var i = 0
        while(i < str.length) {
            var j = i
            while(str[j] != '#') j++
            val len = str.substring(i,j).toInt()
            i = j+1
            res.add(str.substring(i, i + len))
            i += len
        }
        return res
    }
}
