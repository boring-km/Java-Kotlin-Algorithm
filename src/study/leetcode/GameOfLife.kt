package study.leetcode

// https://leetcode.com/problems/game-of-life/
object GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val n = board.size
        val m = board[0].size

        val array = Array(n) { IntArray(m) }

        val moveX = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
        val moveY = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)

        for (y in 0 until n) {
            for (x in 0 until m) {
                val target = board[y][x]
                // if 1, 2, 3
                var liveCount = 0
                for (i in moveX.indices) {
                    val nextY = y + moveY[i]
                    val nextX = x + moveX[i]
                    if (nextY in 0 until n && nextX in 0 until m) {
                        if (board[nextY][nextX] == 1) {
                            liveCount++
                        }
                    }
                }
                if (target == 1) {
                    if (liveCount == 2 || liveCount == 3) {
                        array[y][x] = 1
                    } else {
                        array[y][x] = 0
                    }
                } else {
                    if (liveCount == 3) {
                        array[y][x] = 1
                    }
                }
            }
        }

        array.copyInto(board)
    }
}

fun main() {
    val board = arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0))
    GameOfLife.gameOfLife(board)
    for (i in 0 until 4) {
        for (j in 0 until 3) {
            print("${board[i][j]} ")
        }
        println()
    }
}