package study.programmers

object Programmers_87390 {
    fun solution(n: Int, left: Long, right: Long): IntArray {

        val list = arrayListOf<Int>()
        var temp = left
        while (temp <= right) {
            list.add((Math.max(temp / n, temp++ % n) + 1).toInt())
        }

        return list.toIntArray()
    }
}

fun main() {
    val n = 6
    val result = Programmers_87390.solution(n, 5, 11)
    for (i in result.indices) {
        if (i != 0 && i % n == 0)
            println()
        print("${result[i]}, ")
    }
}
/*
123
223
333


1234
    2223
        3334
            4444

arr 길이: n * n

7 = 4 * (0 + 1) + 3

14 = 4 * (0 + 3) + 2
123456
       223456
             333456
                  444456
                        555556
                              66666

                              6
 */