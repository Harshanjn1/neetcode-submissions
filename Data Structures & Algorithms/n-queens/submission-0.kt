class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val board = Array(n){CharArray(n){'.'}}
        val col = HashSet<Int>()
        val posDia = HashSet<Int>()
        val negDia = HashSet<Int>()

        fun backtrack(r: Int) {
            if(r == n) {
                res.add(board.map{
                    it.joinToString("")
                })
                return
            }

            for(c in 0 until n) {
                if(c in col || r+c in posDia || r-c in negDia) {
                    continue
                }

                col.add(c)
                posDia.add(r+c)
                negDia.add(r-c)
                board[r][c] = 'Q'

                backtrack(r+1)

                col.remove(c)
                posDia.remove(r+c)
                negDia.remove(r-c)
                board[r][c] = '.'
            }
        }

        backtrack(0)
        return res
    }
}
