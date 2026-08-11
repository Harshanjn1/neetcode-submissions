class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) {HashSet<Char>()}
        val cols = Array(9) {HashSet<Char>()}
        val square = Array(9) {HashSet<Char>()}

        for(i in 0 until 9) {
            for (j in 0 until 9) {
                val value = board[i][j]
                if(value == '.') continue
                val squareIndex = (i / 3) * 3 + (j / 3)
                if(value in rows[i] || value in cols[j] || 
                value in square[squareIndex]) {
                    return false
                }

                rows[i].add(value)
                cols[j].add(value)
                square[squareIndex].add(value)
            }
        }

        return true
    }
}
