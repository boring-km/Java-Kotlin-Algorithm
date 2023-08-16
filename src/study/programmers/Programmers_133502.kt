package study.programmers

import java.util.Stack

object Programmers_133502 {
    fun solution(ingredient: IntArray): Int {
        var answer = 0

        val stack = Stack<Int>()

        for (item in ingredient) {
            stack.push(item)

            val size = stack.size
            if (size >= 4) {
                if (stack[size - 4] == 1 && stack[size - 3] == 2 && stack[size - 2] == 3 && stack[size - 1] == 1)  {
                    answer++
                    for (i in 0 until 4) stack.pop()
                }
            }
        }

        return answer
    }
}