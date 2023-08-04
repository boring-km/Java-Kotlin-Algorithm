package study.programmers

object Programmers_136798 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (i in 1 .. number) {
            val temp = getDivisor(i)
            if (temp > limit) {
                answer += power
            } else {
                answer += temp
            }
        }

        return answer
    }

    // 약수의 개수 구하기
    private fun getDivisor(n: Int): Int {
        var count = 0
        for (i in 1..n/2) {
            if (n % i == 0) count++
        }
        return count + 1
    }

}
