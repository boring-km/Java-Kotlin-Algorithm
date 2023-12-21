package study.leetcode

object `sqrt(x)` {
    fun mySqrt(x: Int): Int {

        var answer = 1L

        while (answer * answer <= x) {
            answer++
        }

        return (answer - 1).toInt()
    }
}