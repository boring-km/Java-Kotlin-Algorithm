package study.programmers

object Programmers_135808 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        score.sortDescending()

        val box = Math.floor(score.size.toDouble() / m).toInt()

        var answer = 0

        for (i in 1 .. box) {
            answer += score[m * i - 1] * m
        }

        return answer
    }
}
