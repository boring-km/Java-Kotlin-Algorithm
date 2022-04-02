package study.leetcode

// https://leetcode.com/problems/search-a-2d-matrix
object Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val n = matrix.size
        val m = matrix[0].size

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == target) {
                    return true
                } else if (matrix[i][j] > target) {
                    return false
                }
            }
        }


        return false
    }
}

fun main() {
    val result = Search2DMatrix.searchMatrix(arrayOf(
        intArrayOf(1,3,5,7)
    ), 3)
    println(result)
}