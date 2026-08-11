class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Bit manupulation logic

        val rows = IntArray(9)
        val cols = IntArray(9)
        val square = IntArray(9)

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val value = board[r][c]
                if(value == '.') continue

                val position = value - '1'

                val bit = 1 shl position
                val squareId = (r / 3) * 3 + (c / 3)

                if(rows[r] and bit != 0 || cols[c] and bit != 0 || 
                square[squareId] and bit != 0) {
                    return false
                }

                rows[r] = rows[r] or bit
                cols[c] = cols[c] or bit
                square[squareId] = square[squareId] or bit
            }
        }

        return true

        // val rows = Array(9) {HashSet<Char>()}
        // val cols = Array(9) {HashSet<Char>()}
        // val square = Array(9) {HashSet<Char>()}

        // for(i in 0 until 9) {
        //     for (j in 0 until 9) {
        //         val value = board[i][j]
        //         if(value == '.') continue
        //         val squareIndex = (i / 3) * 3 + (j / 3)
        //         if(value in rows[i] || value in cols[j] || 
        //         value in square[squareIndex]) {
        //             return false
        //         }

        //         rows[i].add(value)
        //         cols[j].add(value)
        //         square[squareIndex].add(value)
        //     }
        // }

        // return true
    }
}
