class Solution {
    fun rotate(matrix: Array<IntArray>) {
        var l = 0
        var r = matrix.size - 1
        while (l < r) {
            for(i in 0 until r - l) {
                val top = l
                val bottom = r

                // save top left element
                val topLeft = matrix[top][l+i]

                // move bottom left to top left
                matrix[top][l+i] = matrix[bottom-i][l]

                // move bottom right to bottm left
                matrix[bottom-i][l] = matrix[bottom][r-i]

                // move top right to bottom right
                matrix[bottom][r-i] = matrix[top+i][r]

                // shift top left to top right
                matrix[top+i][r] = topLeft
            }
            l++
            r--
        }
    }
}
