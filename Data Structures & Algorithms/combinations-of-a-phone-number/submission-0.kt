class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val res = mutableListOf<String>()
        val digitToChar = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        fun backtrack(i: Int, cur:String) {
            if(cur.length == digits.length) {
                res.add(cur)
                return
            }

            for(c in digitToChar[digits[i]]!!) {
                backtrack(i+1, cur+c)
            }
        }

        backtrack(0, "")
        return res
    }
}
