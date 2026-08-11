class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val size = s.length

        var res = 0
        var l = 0
        
        val map = HashMap<Char, Int>()

        for (r in s.indices) {
            if(s[r] in map) {
                map[s[r]]?.let {
                    l = max(l , it + 1)
                }

            }

            map[s[r]] = r
            res = max(res, r - l + 1)
        }

        return res
    }
}
