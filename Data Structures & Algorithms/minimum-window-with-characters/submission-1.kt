class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.isEmpty()) return ""

        val countT = HashMap<Char, Int>()
        for(c in t) {
            countT[c] = countT.getOrDefault(c, 0) + 1
        }

        var have = 0
        var need = countT.size
        var resLen = Int.MAX_VALUE
        var res = IntArray(2) { -1 }

        var l = 0
        val window = HashMap<Char, Int>()
        for(r in s.indices) {
            val c = s[r]
            window[c] = window.getOrDefault(c, 0) + 1
            if(countT.containsKey(c) && countT[c] == window[c]) {
                have++
            }

            while(have == need) {
                if(r - l + 1 < resLen) {
                    resLen = r - l + 1
                    res[0] = l
                    res[1] = r
                }

                window[s[l]] = window.getOrDefault(s[l], 0) - 1
                if(countT.containsKey(s[l]) && window[s[l]] ?: 0 < countT[s[l]]!!) {
                    have--
                }
                l++
            }
        }

        return if(res[0] == -1) "" else s.substring(res[0], res[1] + 1)
    }
}
