package study.programmers

object Programmers_87390 {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer: IntArray

        val leftMok = left / n
        val leftNam = left % n

        val dataList = arrayListOf<Long>()
        for (i in leftNam until n) {
            var bonus = 0
            if (i - leftNam + 1 < leftMok) {
                dataList.add(leftMok + 1)
            } else {
                if (leftNam == 0L && i < leftMok) bonus = 1
                dataList.add(i + bonus + 1)
            }
        }

        val diff = (right - left + 1).toInt()
        if (diff <= dataList.size) {
            answer = IntArray(diff)
        } else {
            // 중간에 추가로 들어가는 행이 있다면
            val rightMok = right / n
            val rightNam = right % n
            if (dataList.size + n < diff) {
                for (i in 0 until rightMok - leftMok - 1) {
                    val cur = i + leftMok + 1 + 1
                    for (j in 0 until n) {
                        if (j < cur) {
                            dataList.add(cur)
                        } else {
                            dataList.add((j + 1).toLong())
                        }
                    }
                }
            }

            for (i in 0 .. rightNam) {
                if (i < rightMok + 1) {
                    dataList.add(rightMok + 1)
                } else {
                    dataList.add(i + rightMok)
                }
            }
            answer = IntArray(dataList.size)
        }
        for (i in answer.indices) {
            answer[i] = dataList[i].toInt()
        }
        return answer
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