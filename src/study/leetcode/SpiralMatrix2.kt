package study.leetcode

// https://leetcode.com/problems/spiral-matrix-ii/
object SpiralMatrix2 {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }

        val cur = intArrayOf(0, 0)
        result[0][0] = 1
        var dir = 0
        for (i in 1  until n * n) {
            if (dir == 0) {
                if (cur[1] + 1 < n && result[cur[0]][cur[1] + 1] == 0) {
                    cur[1]++    // x 우측으로 한칸 이동
                } else {
                    cur[0]++    // y 아래로 한칸 이동
                    dir = 1     // 방향 전환
                }
                if (result[cur[0]][cur[1]] == 0)
                    result[cur[0]][cur[1]] = i + 1
            } else if (dir == 1) {
                if (cur[0] + 1 < n && result[cur[0]+1][cur[1]] == 0) {
                    cur[0]++
                } else {
                    cur[1]--
                    dir = 2
                }
                if (result[cur[0]][cur[1]] == 0)
                    result[cur[0]][cur[1]] = i + 1
            } else if (dir == 2) {
                if (cur[1] - 1 >= 0 && result[cur[0]][cur[1] - 1] == 0) {
                    cur[1]--
                } else {
                    cur[0]--
                    dir = 3
                }
                if (result[cur[0]][cur[1]] == 0)
                    result[cur[0]][cur[1]] = i + 1
            } else {
                if (cur[0] - 1 > 0 && result[cur[0]-1][cur[1]] == 0) {
                    cur[0]--
                } else {
                    cur[1]++
                    dir = 0
                }
                if (result[cur[0]][cur[1]] == 0)
                    result[cur[0]][cur[1]] = i + 1
            }
        }

        return result
    }
}

fun main() {
    val result = SpiralMatrix2.generateMatrix(5)
    result.forEach {
        it.forEach { num -> print("$num ") }
        println()
    }
}