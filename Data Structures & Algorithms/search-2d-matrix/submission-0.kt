class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        val size = matrix.size * matrix[0].size
        var r = size - 1

        while(l <= r ) {
            val mid = l + (r - l) / 2
            val row = mid / matrix[0].size
            val col = mid % matrix[0].size

            when {
                matrix[row][col] > target -> r = mid - 1
                matrix[row][col] < target -> l = mid + 1
                else -> return true
            }

        }
        return false
    }
}
