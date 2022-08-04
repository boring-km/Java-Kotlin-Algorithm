package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/92335
private object Programmers_92335 {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val str = change(n, k)

        val arr = str.split('0')
        arr.forEach{
            if (it.isNotEmpty() && isPrimeNumber(it.toLong())) answer++
        }

        return answer
    }

    fun change(num: Int, k: Int): String {
        var result = ""
        if (num == 0) return "0"
        var temp = num
        while (temp > 0) {
            result = "${temp % k}" + result
            temp /= k
        }
        return result
    }

    fun isPrimeNumber(it: Long): Boolean {
        val root = Math.sqrt(it.toDouble()).toInt()
        if (it == 1L) return false
        for (i in 2 .. root) {
            if (it % i == 0L) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val result = Programmers_92335.solution(110011, 10)
    println(result)
}