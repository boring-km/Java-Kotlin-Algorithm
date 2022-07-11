package study.programmers

import java.lang.Long


object Programmers_77885 {
    fun solution(numbers: LongArray): LongArray {
        val answer = LongArray(numbers.size)

        for (i in numbers.indices) {
            val num = numbers[i]
            val toBinaryNumString = Long.toBinaryString(num)
            var temp = num

            while (true) {
                temp++;

                val toBinaryTempString = Long.toBinaryString(temp)
                val maxSize = Math.max(toBinaryNumString.length, toBinaryTempString.length)

                val binNum = toBinaryNumString.padStart(maxSize, '0')
                val binTemp = toBinaryTempString.padStart(maxSize, '0')
                var count = 0
                for (j in maxSize-1 downTo 0 ) {
                    if (binNum[j] != binTemp[j]) {
                        count++
                    }
                    if (count > 2) {
                        break
                    }
                }
                if (count == 1 || count == 2) {
                    break
                }
            }
            answer[i] = temp
        }

        return answer
    }
}

fun main() {

    println( Long.toBinaryString(0b1100.and(0b1001)))

//    println(7.and(9))
//    val results = Programmers_77885.solution(longArrayOf(2,7))
//    results.forEach { println(it) }
}