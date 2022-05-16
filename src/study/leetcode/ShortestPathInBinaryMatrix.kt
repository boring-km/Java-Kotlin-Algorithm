package study.leetcode

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
object ShortestPathInBinaryMatrix {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

        val h = grid.size
        val w = grid[0].size

        if (grid.isEmpty()) return -1
        if (grid[0][0] != 0) return -1

        // y, x
        val move = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 1),
            intArrayOf(-1, 1),
            intArrayOf(1, -1),
            intArrayOf(-1, -1)
        )

        val queue = ArrayDeque<IntArray>()
        queue.add(intArrayOf(0, 0, 0))

        while (queue.isNotEmpty()) {
            val temp = queue.removeLast()
            if (temp[0] == h - 1 && temp[1] == w - 1) {
                return temp[2]+1
            }

            for (k in 0 until 8) {
                val m = move[k]
                val ty = temp[0] + m[0]
                val tx = temp[1] + m[1]

                if (ty in 0 until h && tx in 0 until w && grid[ty][tx] == 0) {
                    grid[ty][tx] = -1
                    queue.addFirst(intArrayOf(ty, tx, temp[2] + 1))
                }
            }
        }

        return -1
    }
}

fun main() {
    val result = ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(
        arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,0,0),
            intArrayOf(0,0,0)
        )
    )
    println(result)
}