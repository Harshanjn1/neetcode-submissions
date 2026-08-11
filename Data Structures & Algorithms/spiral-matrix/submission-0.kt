class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var top = 0
        var right = matrix[0].size
        var bottom = matrix.size
        var left = 0
        val res = mutableListOf<Int>()

        while(top < bottom && left < right) {
            // iterate the top row
            for(i in left until right) {
                res.add(matrix[top][i])
            }
            top++

            //iterate the right column
            for(i in top until bottom) {
                res.add(matrix[i][right-1])
            }
            right--

            if(!(left < right && top < bottom)) break

            //iterate last row
            for(i in right - 1 downTo left) {
                res.add(matrix[bottom-1][i])
            }
            bottom--

            for(i in bottom - 1 downTo top) {
                res.add(matrix[i][left])
            }
            left++
        }
        return res
    }
}
