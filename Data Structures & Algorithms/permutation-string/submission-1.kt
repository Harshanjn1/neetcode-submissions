class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val count1 = HashMap<Char, Int>()
        for (c in s1) {
            count1[c] = 1 + count1.getOrDefault(c, 0)
        }

        val need = count1.size
        for (i in s2.indices) {
            val count2 = mutableMapOf<Char, Int>()
            var cur = 0
            for (j in i until s2.length) {
                count2[s2[j]] = 1 + count2.getOrDefault(s2[j], 0)
                if (count1.getOrDefault(s2[j], 0) < count2[s2[j]]!!) {
                    break
                }
                if (count1.getOrDefault(s2[j], 0) == count2[s2[j]]!!) {
                    cur++
                }
                if (cur == need) {
                    return true
                }
            }
        }
        return false
    }
}
