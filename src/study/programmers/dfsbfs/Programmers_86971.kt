package study.programmers.dfsbfs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

private object Programmers_86971 {

    var list: Array<ArrayList<Int>>? = null

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 100

        list = Array(n+1) { arrayListOf() }
        for (wire in wires) {
            list!![wire[0]].add(wire[1])
            list!![wire[1]].add(wire[0])
        }
        // 모든 wire 완전탐색
        for (wire in wires) {
            // wire = [ 왼쪽, 오른쪽 ]
            val n1 = bfs(wire[0], wire[1], n) // wire 왼쪽만 탐색
            val n2 = bfs(wire[1], wire[0], n) // wire 오른쪽만 탐색
            // 이 wire를 끊었을 때 그 길이의 차이는?
            answer = min(answer, abs(n1 - n2))
        }

        return answer
    }

    fun bfs(root: Int, target: Int, n: Int): Int {
        val visited = BooleanArray(n+1)
        val queue: Queue<Int> = LinkedList()
        queue.add(root)
        var count = 0
        visited[root] = true
        while (!queue.isEmpty()) {
            val cur = queue.poll()
            count++
            for (next in list!![cur]) {
                if (next != target && !visited[next]) { // v2만 빼고 방문
                    queue.add(next)
                    visited[next] = true
                }
            }
        }
        return count
    }
}

fun main() {
    val result = Programmers_86971.solution(
        9,
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(4, 6),
            intArrayOf(4, 7),
            intArrayOf(7, 8),
            intArrayOf(7, 9)
        )
    )
    println("result: $result")
}