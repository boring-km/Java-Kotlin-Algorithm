package study.programmers.greedy

import java.util.*

object Programmers_118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val deque1: Deque<Int> = LinkedList(queue1.toList())
        val deque2: Deque<Int> = LinkedList(queue2.toList())

        var leftSum = queue1.sum().toLong()
        var rightSum = queue2.sum().toLong()

        val n = queue1.size
        var count = 0
        while (leftSum != rightSum) {
            if (count > n * 4) {
                return -1
            }
            if (leftSum < rightSum) {
                val item = deque2.pollFirst()
                deque1.addLast(item)
                rightSum -= item
                leftSum += item
            } else if (leftSum > rightSum) {
                val item = deque1.pollFirst()
                deque2.addLast(item)
                leftSum -= item
                rightSum += item
            }
            count++
        }

        return count
    }
}


fun main() {
    val result = Programmers_118667.solution(intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1))
    println(result)

    val result2 = Programmers_118667.solution(intArrayOf(1, 2, 1, 2), intArrayOf(1, 1, 10, 2))
    println(result2)

    val result3 = Programmers_118667.solution(intArrayOf(1, 1), intArrayOf(1, 5))
    println(result3)
}