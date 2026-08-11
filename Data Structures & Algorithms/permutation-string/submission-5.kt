class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        if(s1.length > s2.length) return false

        val count1 = IntArray(26)
        val count2 = IntArray(26)
        var matches = 0
        for(i in s1.indices) {
                count1[s1[i] - 'a'] ++
                count2[s2[i] - 'a'] ++
        }

        for (i in 0 until 26) {
                if (count1[i] == count2[i]) matches++
        }

        var l = 0
        for(r in s1.length until s2.length) {
            if(matches == 26) return true

            val index = s2[r] - 'a'
            count2[index] ++

            if(count1[index] == count2[index]) {
                matches++
            } else if (count1[index] + 1 == count2[index]) {
                matches--
            }

            val removedIndex = s2[l] - 'a'
            count2[removedIndex]--

            if(count1[removedIndex] == count2[removedIndex]) {
                matches++
            } else if (count1[removedIndex] - 1 == count2[removedIndex]) {
                matches--
            }
            l++

        }

        return matches == 26
    }
}
