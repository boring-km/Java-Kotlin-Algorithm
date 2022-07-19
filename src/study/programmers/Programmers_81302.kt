package study.programmers

import java.util.LinkedList
import java.util.Queue

private object Programmers_81302 {

    private val moves = arrayOf(arrayOf(1, 0), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(0, -1))

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size)

        for (i in places.indices) {
            answer[i] = bfs(places[i])
        }

        return answer
    }

    fun bfs(place: Array<String>): Int {
        val visited = Array(5) { BooleanArray(5) { false } }
        val queue: Queue<IntArray> = LinkedList()
        for (y in 0 until 5) {
            for (x in 0 until 5) {
                if (place[y][x] == 'P' && !visited[y][x]) {
                    queue.add(intArrayOf(y, x, 2))
                    visited[y][x] = true
                    while (queue.isNotEmpty()) {
                        val items = queue.poll()
                        if (items!![2] == 0) continue
                        for (move in moves) {
                            val ty = items[0] + move[0]
                            val tx = items[1] + move[1]
                            if (ty in 0..4 && tx in 0..4 && !visited[ty][tx]) {
                                if (place[ty][tx] == 'P') {
                                    return 0
                                } else if (place[ty][tx] == 'O') {
                                    queue.add(intArrayOf(ty, tx, items[2] - 1))
                                    visited[ty][tx] = true
                                } else {
                                    // 파티션 있으면 그냥 탐색 안함
                                    queue.add(intArrayOf(ty, tx, 0))
                                    visited[ty][tx] = true
                                }
                            }
                        }
                    }
                }
            }
        }

        return 1
    }
}

fun main() {
    val result = Programmers_81302.solution(
        arrayOf(
            arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
            arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
            arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
        )
    )
    result.forEach { print("$it, ") }
}
/*
"PXOPX",
"OXOXP",
"OXPOX",
"OXXOP",
"PXPOX"
 */