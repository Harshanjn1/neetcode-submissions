class Solution {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while(l < r) {
            while(r > l && s[r].isLetterOrDigit().not()) r--
            while(l < r && s[l].isLetterOrDigit().not()) l++
            if(s[l].lowercase() != s[r].lowercase()) return false
            l++
            r-- 
        }
        return true
    }
}
