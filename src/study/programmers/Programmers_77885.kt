package study.programmers


// https://school.programmers.co.kr/learn/courses/30/lessons/77885
// https://velog.io/@courage331/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-2%EA%B0%9C-%EC%9D%B4%ED%95%98%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EB%B9%84%ED%8A%B8
object Programmers_77885 {
    fun solution(numbers: LongArray): LongArray {
        val answer = LongArray(numbers.size)

        for (i in numbers.indices) {
            var bin = java.lang.Long.toBinaryString(numbers[i])

            if (numbers[i].mod(2) == 0) {
                answer[i] = numbers[i] + 1  // 짝수면 뒤에가 10 이거나 00 이니까 +1만 하면 됨
            } else {
                val last = bin.lastIndexOf("0")     // 마지막 0 찾기
                val first = bin.indexOf("1", last)  // 마지막 0 바로 다음에 나오는 1
                if (last == -1) {   // 0이 없으면 -> 11111
                    numbers[i] = numbers[i].plus(1) // 1을 더하기 -> 100000
                    bin = java.lang.Long.toBinaryString(numbers[i]) // 더한 숫자를 이진수로 변환
                    // 101111
                    bin = bin.substring(0, 2) +
                                bin.substring(2, bin.length).replace("0", "1")  // 011111 -> 101111 2개 차이
                } else {
                    // 0이 있으면
                    // ...0 -> 1 ... 1 -> 0 ...
                    bin = bin.substring(0, last) + "1" +
                            bin.substring(last + 1, first) + "0" +
                            bin.substring(first + 1, bin.length)
                }
                answer[i] = java.lang.Long.parseLong(bin, 2)
            }
        }

        return answer
    }
}

fun main() {
    val results = Programmers_77885.solution(longArrayOf(2,7))
    results.forEach { println(it) }
}