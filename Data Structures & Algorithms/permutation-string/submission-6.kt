class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        val counts1 = IntArray(26)
        val counts2 = IntArray(26)

        for(i in s1.indices) {
            counts1[s1[i] - 'a']++
            counts2[s2[i] - 'a']++
        }
        var matches = 0
        for(i in 0 until 26) {
            if(counts1[i] == counts2[i]) matches++
        }
        var l = 0
        for(r in s1.length until s2.length) {
            if(matches == 26) return true
            val index = s2[r] - 'a'
            counts2[index]++
            if(counts1[index] == counts2[index]){
                matches++
            } else if(counts1[index] + 1 == counts2[index]) {
                matches--
            }
            val indexL = s2[l] - 'a'
            counts2[indexL]--
            if(counts1[indexL] == counts2[indexL]){
                matches++
            } else if(counts1[indexL] - 1 == counts2[indexL]) {
                matches--
            }
            l++
        }

        return matches == 26

    }
}
