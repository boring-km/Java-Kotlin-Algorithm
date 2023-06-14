package study.programmers

object Programmers_161989 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 1
        var temp = section.first()

        for (i in 1 until section.size) {
            // 현재 칠해야하는 구간의 길이가 m보다 크거나 같으면?
            if (section[i] - temp >= m) {
                answer++
                temp = section[i]   // 다음 구간 이동
            }
        }
        return answer
    }
}

fun main() {
    val result = Programmers_161989.solution(8, 4, intArrayOf(2,3,6))
    println(result)
}