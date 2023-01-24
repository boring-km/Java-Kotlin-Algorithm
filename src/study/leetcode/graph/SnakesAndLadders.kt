package study.leetcode.graph

import java.util.*


object SnakesAndLadders {
    fun snakesAndLadders(board: Array<IntArray>): Int {

        val valueMap: MutableMap<Int, Int> = HashMap()
        val n: Int = board.size

        val total = n * n
        var direction = 1

        var row = n - 1 // 맨 아래 줄부터 시작
        var column = 0

        for (i in 1..total) {
            valueMap[i] = board[row][column]
            // 다음 줄
            if (i % n == 0) {
                row-- // 위로 이동
                direction *= -1 // 방향 전환
            } else {
                // 다음 칸 (왼쪽 혹은 오른쪽)
                column += direction
            }
        }

        return bfs(total, valueMap)
    }

    private fun bfs(total: Int, valueMap: MutableMap<Int, Int>): Int {
        // 움직인 횟수
        var moves = 0

        // 방문한 위치 기록
        val visits = IntArray(total + 1)
        visits[1] = 1

        // 시작점은 1
        val queue: Queue<Int> = LinkedList()
        queue.offer(1)
        while (!queue.isEmpty()) {
            moves++
            val size = queue.size
            for (i in 0 until size) {
                val cell = queue.poll() // 이번에 탐색할 위치 꺼내보기
                // 주사위로 갈 수 있는 최대로 먼 곳
                val maxCell = (cell + 6).coerceAtMost(total)
                // 다음 위치부터 주사위로 갈 수 있는 마지막까지
                for (j in cell + 1..maxCell) {
                    // 도착
                    if (j == total) {
                        return moves
                    }
                    // 다음 값
                    val value = valueMap[j]!!
                    if (value == -1) {  // 사다리 없음
                        // 방문한 곳이 아니라면?
                        if (visits[j] and 1 == 0) {
                            visits[j]++
                            // 다음 방문 장소 등록
                            queue.offer(j)
                        }
                    } else { // 사다리 있음
                        // 마지막이라면?
                        if (value == total) {
                            return moves
                        }
                        // 방문한 곳이 아니라면?
                        if (visits[value] and 2 == 0) {
                            visits[value] += 2
                            // 다음 방문 장소 등록
                            queue.offer(value)
                        }
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val result = SnakesAndLadders.snakesAndLadders(arrayOf(intArrayOf(1, 1, -1), intArrayOf(1, 1, 1), intArrayOf(-1, 1, 1)))
    println(result)

    println(4 and 2)
    println(2 and 2)
    println(1 and 2)
    println(-1 and 2)
    println(-2 and 2)
}