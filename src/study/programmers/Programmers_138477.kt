package study.programmers

import java.util.*

object Programmers_138477 {
    fun solution(k: Int, score: IntArray): IntArray {
        val answer = IntArray(score.size)

        val queue = PriorityQueue<Int>()

        for (i in score.indices) {
            val s = score[i]
            if (queue.size < k) {
                queue.add(s)
                answer[i] = queue.peek()
            } else {
                if (queue.peek() < s) {
                    queue.remove()
                    queue.add(s)
                }
                answer[i] = queue.peek()
            }
        }

        return answer
    }
}

fun main() {
    val result = Programmers_138477.solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200))
    result.forEach { print("$it ") }

    val result2 = Programmers_138477.solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000))
    result2.forEach { print("$it ") }
}