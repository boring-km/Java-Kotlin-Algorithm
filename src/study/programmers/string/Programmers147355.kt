package study.programmers.string

object Programmers147355 {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        for (i in 0 .. t.length - p.length) {
            if (p.toLong() >= t.substring(i, i+p.length).toLong()) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    Programmers147355.solution("1", "1")
}