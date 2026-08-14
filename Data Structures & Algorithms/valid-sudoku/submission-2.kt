class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = IntArray(9)
        val cols = IntArray(9)
        val square = IntArray(9)

        for(r in 0 until 9) {
            for(c in 0 until 9) {
                val value = board[r][c] - '1'
                val bit = 1 shl value
                val squareIndex = ((r / 3) * 3) + c / 3

                if(board[r][c] == '.') continue
                if(rows[r] and bit != 0 || cols[c] and bit != 0 
                || square[squareIndex] and bit !=0) {
                    return false
                }

                rows[r] = rows[r] or bit
                cols[c] = cols[c] or bit
                square[squareIndex] = square[squareIndex] or bit
            }
        }
        return true
    }
}
