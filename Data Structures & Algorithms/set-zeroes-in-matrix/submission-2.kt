class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rows = matrix.size
        val cols = matrix[0].size
        var rowZero = false

        // marking the zero's rows or colums using first row and column
        for(r in 0 until rows) {
            for(c in 0 until cols) {
                if(matrix[r][c] == 0) {
                    if(r > 0) {
                        matrix[r][0] = 0
                    } else {
                        rowZero = true
                    }
                    matrix[0][c] = 0
                }
            }
        }

        // now make all the elements zero if the row or column contains zero
        for(r in 1 until rows) {
            for(c in 1 until cols) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(r in 0 until rows) {
                matrix[r][0] = 0
            }
        }

        if(rowZero) {
            for(c in 0 until cols) {
                matrix[0][c] = 0
            }
        }

    }
}
