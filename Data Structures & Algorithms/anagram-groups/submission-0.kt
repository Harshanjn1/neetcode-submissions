class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for(str in strs) {
            val count = IntArray(26)
            for(i in 0..<str.length) {
                count[str[i] - 'a'] ++
            }
            var key = ""
            for (j in 0..<26) {
                key += '#' + count[j]
            }
            map.getOrPut(key){mutableListOf<String>()}.add(str)
        }
        val res= mutableListOf<List<String>>()
        for (value in map.values )
         {
            res.add(value)
         }
         return res
    }
}
