package study.programmers

object Programmers_131128 {
    fun solution(X: String, Y: String): String {
        var answer: String = ""

        val xArr = Array(10) { 0 }
        val yArr = Array(10) { 0 }

        for (c in X) {
            xArr[Character.getNumericValue(c)] += 1
        }
        for (c in Y) {
            yArr[Character.getNumericValue(c)] += 1
        }
        for (i in 9 downTo 0) {
            if (xArr[i] != 0 && yArr[i] != 0) {
                answer += if (i == 0 && answer.isEmpty()) "0"
                else "$i".repeat(Math.min(xArr[i], yArr[i]))
            }
        }

        return if (answer.isEmpty()) "-1" else answer
    }
}

fun main() {
    println(Programmers_131128.solution("999009", "111900"))
}