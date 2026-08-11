class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val partition = mutableListOf<String>()

        fun dfs(i: Int, j: Int) {
            if(j >= s.length) {
                if(i == j) {
                    res.add(partition.toList())
                }
                return
            }

            if(isPalindrome(i, j, s)) {
                partition.add(s.substring(i, j+1))
                dfs(j+1, j+1)
                partition.removeLast()
            }

            dfs(i, j+1)
        }
        dfs(0,0)
        return res
    }

    private fun isPalindrome(l: Int, r: Int, string:String): Boolean {
        var left = l
        var right = r
        while (left < right) {
            if(string[left] != string[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}
