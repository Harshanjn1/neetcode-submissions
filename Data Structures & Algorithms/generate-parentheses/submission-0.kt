class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        val stack = mutableListOf<String>()

        fun backTrack(openN: Int, closedN: Int) {
            if(openN == n && closedN == n) {
                res.add(stack.joinToString(""))
                return
            }

            if(openN < n) {
                stack.add("(")
                backTrack(openN+1, closedN)
                stack.removeLast()
            }

            if(closedN < openN) {
                stack.add(")")
                backTrack(openN, closedN+1)
                stack.removeLast()
            }
        }

        backTrack(0,0)
        return res
    }
}
