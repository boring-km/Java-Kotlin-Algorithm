package study.programmers

object Programmers_132265 {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val left = HashMap<Int, Int>()
        val right = HashMap<Int, Int>()

        for (i in topping.indices) {
            right[topping[i]] = right.getOrDefault(topping[i], 0) + 1
        }

        for (i in topping.indices) {
            left[topping[i]] = left.getOrDefault(topping[i], 0) + 1

            if (right[topping[i]]!! - 1 == 0) {
                right.remove(topping[i])
            } else {
                right[topping[i]] = right[topping[i]]!! - 1
            }

            if (left.size == right.size) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    println(Programmers_132265.solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
}