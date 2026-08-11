class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val size = s.length
        var l = 0
        var maxFreq = 0
        var res = 0
        val map = HashMap<Char, Int>()
        for (r in s.indices) {
            map[s[r]] = map.getOrDefault(s[r], 0) + 1
            maxFreq = max(maxFreq, map[s[r]]!!)
            while((r - l + 1) - map.values.max() > k) {
                map[s[l]] = map[s[l]]!! - 1
                l++
            }
            res = max(res, (r - l + 1))
        }

        return res
    }
}
