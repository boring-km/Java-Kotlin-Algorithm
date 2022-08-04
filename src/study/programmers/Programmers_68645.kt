package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/68645
private object Programmers_68645 {
    fun solution(n: Int): IntArray {
        val size = (1+n) * n / 2
        val answer = IntArray(size)
        var cur = n
        var count = 0
        var state = 0
        var index = 0

        val board = Array(n+1) {IntArray(n+1) {0} }
        var x = 0
        var y = 0

        for (i in 1 until size+1) {
            // 총 3방향
            if (state == 0) {
                board[++y][x] = i
            } else if (state == 1) {
                board[y][++x] = i
            } else {
                board[--y][--x] = i
            }

            if (cur == i) {
                if (state < 2) state++
                else state = 0
                cur += n - ++count
//                println("cur: $cur, count: $count, i: $i, state: $state")
            }
        }
        for (i in 0 until n+1) {
            for (j in 0 until n+1) {
                if (board[i][j] == 0) break
                answer[index++] = board[i][j]
            }
        }

        /*
        1
        2 15
        3 16 14
        4 17 21 13
        5 18 19 20 12
        6  7 8  9  10 11
         */

        return answer
    }
}

fun main() {
    val result = Programmers_68645.solution(6)
    result.forEach { print("$it, ") }
}