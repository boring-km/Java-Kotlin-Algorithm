package study.leetcode.string

object Programmers140108 {
    fun solution(s: String): Int {

        if (s.length == 1) return 1

        var answer = 0

        var start = 1
        var first = s[0]

        for (c in s.substring(1)) {
            if (start == 0) {
                first = c
                start = 0
            }
            if (c == first) {
                start++
            } else {
                start--
                if (start == 0) {
                    answer++
                }
            }
        }
        if (start != 0) {
            answer++
        }

        return answer
    }
}

fun main() {
    val result = Programmers140108.solution("banana")
    println(result)
}