package study.programmers

import java.util.*

object Programmers_154539 {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size)

        val stack = Stack<Int>()
        stack.push(0)

        for (i in 1 until numbers.size) {
            while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }

        while (stack.isNotEmpty()) {
            answer[stack.pop()] = -1
        }

        return answer
    }
}