class Solution {
    fun isPalindrome(s: String): Boolean {
        val size = s.length
        var start = 0
        var end = size - 1

        while (start < end) {
            while(start < end && s[start].isLetterOrDigit().not()) {
                start++
            }

            while(start < end && s[end].isLetterOrDigit().not()) {
                end--
            }
            if(s[start].lowercase() != s[end].lowercase()) {
                return false
            }
            start++
            end--
        }

        return true
    }
}
