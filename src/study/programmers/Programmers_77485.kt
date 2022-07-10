package study.programmers


// https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=kotlin
object Programmers_77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size) { 0 }

        /*
            1. rows x columns board 준비
            2. board에서 queries[qi] 회전을 수행하고 board에 저장
            3. 회전한 값들 중 최솟값을 answer에 저장
         */
        val board = Array(rows) { i -> IntArray(columns) { j -> i * columns + j + 1 } }

        for (qi in queries.indices) {
            val tempList = arrayListOf<IntArray>()
            val q: IntArray = queries[qi]
            for (y in 1 .. rows) {
                for (x in 1 .. columns) {
                    // 2 2 5 4
                    if (q[0] <= y && y <= q[2] && q[1] <= x && x <= q[3]) {
                        if (y == q[0]) {
                            if (x == q[1]) {
                                tempList.add(intArrayOf(y-1, x-1, board[y][x-1]))
                            } else {
                                tempList.add(intArrayOf(y-1, x-1, board[y-1][x-2]))
                            }
                            continue
                        } else if (x == q[3]) {
                            tempList.add(intArrayOf(y-1, x-1, board[y-2][x-1]))
                            continue
                        } else if (y == q[2]) {
                            tempList.add(intArrayOf(y-1, x-1, board[y-1][x]))
                            continue
                        } else if (x == q[1]) {
                            tempList.add(intArrayOf(y-1, x-1, board[y][x-1]))
                            continue
                        }
                    }
                }
            }
            var tempMin = rows * columns
            for (temp: IntArray in tempList) {
                board[temp[0]][temp[1]] = temp[2]
                tempMin = Math.min(tempMin, temp[2])
            }

            answer[qi] = tempMin  // 최솟값 저장
        }

        return answer
    }
}

fun main() {
    val result = Programmers_77485.solution(
        6,
        6,
        arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))
    )
    result.forEach { print("$it ") }
}