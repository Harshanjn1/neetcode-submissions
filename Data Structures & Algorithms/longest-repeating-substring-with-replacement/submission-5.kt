class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val map = mutableMapOf<Char, Int>()
        var res = 0
        var l = 0
        var maxf = 0
        for(r in s.indices) {
            map[s[r]] = map.getOrDefault(s[r], 0) + 1
            maxf = max(maxf, map[s[r]]!!)
            while((r - l + 1) -  maxf > k) {
                map[s[l]] = map[s[l]]!! - 1
                l++
            }
            res = max(res, r - l + 1)
        }
        return res
    }
}
