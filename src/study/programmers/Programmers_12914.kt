package study.programmers

private object Programmers_12914 {
    fun solution(n: Int): Long {
        val dp = LongArray(n+2){0}
        dp[1] = 1
        dp[2] = 2
        for (i in 3 until n+2) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567
        }
        return dp[n]
    }
}

fun main() {
    val result = Programmers_12914.solution(3)
    println(result)
}