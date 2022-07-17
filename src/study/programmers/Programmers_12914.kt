package study.programmers

private object Programmers_12914 {
    fun solution(n: Int): Long {
        var answer: Long = 1
        var count = n
        // n = 10
        // two x 0
        // two x 1
        // ...
        // two x n / 2

        for (i in 1 until n / 2 + 1) {
            answer += combination(--count, i)
        }

        return answer %  1234567
    }

    fun combination(n: Int, k: Int): Int {
        if (k == n) return 1
        else if (k == 1) return n
        else return combination(n - 1, k - 1) + combination(n - 1, k)
    }
}

fun main() {
    val result = Programmers_12914.solution(2000)
    println(result)
}