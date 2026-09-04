class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var res = 0
        var l = 0
        for(r in s.indices) {
            if(s[r] in map) {
                l = max(l, map[s[r]]!!+1)
            }
            map[s[r]] = r
            res = max(res, r - l +1)
        }
        return res
    }
}
