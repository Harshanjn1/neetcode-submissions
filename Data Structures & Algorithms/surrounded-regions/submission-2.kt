class Solution {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size

        fun capture(r: Int, c: Int) {
            if(r !in 0 until rows || c !in 0 until cols || 
            board[r][c] != 'O') {
                return
            }

            board[r][c] = 'T'
            capture(r+1, c)
            capture(r-1, c)
            capture(r, c+1)
            capture(r, c-1)

        }

        for(r in 0 until rows) {
            for(c in listOf(0, cols-1)) {
                if(board[r][c] == 'O') {
                    capture(r, c)
                }
            }
        }

        for(c in 1 until cols - 1) {
            for(r in listOf(0, rows-1)) {
                if(board[r][c] == 'O') {
                    capture(r, c)
                }
            }
        }
        for(r in 0 until rows) {
            for(c in 0 until cols) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X'
                } else if(board[r][c] == 'T') {
                    board[r][c] = 'O'
                }
            }
        }
    }
}
