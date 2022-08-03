package study.programmers

private object Programmers_92342 {

    var answer = intArrayOf(-1)
    var max = 0

    fun solution(n: Int, info: IntArray): IntArray {

        dfs(info, 0, 0, n, IntArray(n)) // info는 어피치
        return if (max == 0) intArrayOf(-1) else answer
    }

    private fun dfs(apeach: IntArray, start: Int, count: Int, n: Int, scores: IntArray) {
        if (count == n) {
            val ryan = IntArray(11)
            for (score in scores) {
                ryan[10 - score]++
            }

            var ryanPoint = 0
            var apeachPoint = 0

            for (i in 0..10) {  // 0점부터 10점
                val score = 10 - i
                if (ryan[i] > apeach[i]) ryanPoint += score
                else if (ryan[i] < apeach[i]) apeachPoint += score
                else if (apeach[i] != 0 && ryan[i] == apeach[i]) apeachPoint += score
            }
            if (ryanPoint - apeachPoint > max) {
                max = ryanPoint - apeachPoint
                answer = ryan
            }
            return
        }
        for (i in start .. 10) {
            scores[count] = i
            dfs(apeach, i, count+1, n, scores)
        }
    }
}

fun main() {
    val result = Programmers_92342.solution(9, intArrayOf(0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1))
    result.forEach { print("$it,") }
}