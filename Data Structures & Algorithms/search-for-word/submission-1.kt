class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val row = board.size
        val col = board[0].size

        if(word.length > row * col) {
            return false
        }

        fun dfs(r: Int, c: Int, i: Int):Boolean {
            if(i == word.length) {
                return true
            }

            if(r < 0 || c < 0 || r >= row || c >= col || board[r][c] != word[i]
            || board[r][c] == '#') {
                return false
            }

            val temp = board[r][c]
            board[r][c] = '#'

           
            val res = dfs(r+1, c , i+1) || dfs(r-1, c , i+1) || dfs(r, c+1 , i+1)
            || dfs(r, c-1 , i+1)

            board[r][c] = temp

            return res

        }

        for(r in 0 until row){
            for(c in 0 until col) {
                if(dfs(r, c, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
