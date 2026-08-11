class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val countT = HashMap<Char, Int>()
        for(c in t) {
            countT[c] = countT.getOrDefault(c, 0) + 1
        }

        val need = countT.size
        var have = 0
        var resLen = Int.MAX_VALUE
        val resIndex = IntArray(2){-1}
        val countS = HashMap<Char, Int>()
        var l = 0
        for(i in s.indices) {
            val index = s[i]
            countS[index] = countS.getOrDefault(index, 0) + 1
            //update the have count if the frequency is matching
            if(countT.containsKey(index) && countT[index] == countS[index]) {
                have++
            }

            while(have == need) {
                if((i - l + 1) < resLen) {
                    resLen = i - l + 1
                    resIndex[0] = l
                    resIndex[1] = i
                }
                countS[s[l]] = countS.getOrDefault(s[l], 0) - 1
                if(countT.containsKey(s[l]) && countS[s[l]]!! < countT[s[l]]!!) {
                    have--
                }
                l++
            }
        }

        return if(resIndex[0] == -1) return "" else s.substring(resIndex[0], resIndex[1] + 1)
    }
}
