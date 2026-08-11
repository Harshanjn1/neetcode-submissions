class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for(str in strs) {
            val count = IntArray(26)
            for(i in 0..<str.length) {
                count[str[i] - 'a'] ++
            }
            val key = count.joinToString("#") 
            map.getOrPut(key){mutableListOf<String>()}.add(str)
        }
        return map.values.toList()
    }
}
