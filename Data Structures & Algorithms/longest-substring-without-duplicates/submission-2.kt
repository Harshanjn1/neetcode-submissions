class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        var res = 0
        val charSet = HashSet<Char>()

        for(r in s.indices) {
            while(s[r] in charSet) {
                charSet.remove(s[l])
                l++
            }
            charSet.add(s[r])
            res = max(res, r - l + 1)
        }
        return res
    }
}
