class Solution {
    fun partitionLabels(s: String): List<Int> {
        val lastIndexMap = HashMap<Char, Int>()

        s.forEachIndexed{
            i, c -> lastIndexMap[c] = i
        }

        var size = 0
        var end = 0
        val res = mutableListOf<Int>()

        for(i in s.indices) {
            size ++
            end = max(end , lastIndexMap[s[i]]?:0)

            if(i == end) {
                res.add(size)
                size = 0
            }
        }
        return res
    }
}
