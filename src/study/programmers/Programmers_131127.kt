package study.programmers

object Programmers_131127 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        for (i in 0 .. discount.size - 10) {
            val map = HashMap<String, Int>()
            for (j in want.indices) {
                map[want[j]] = number[j]
            }

            for (j in i until i + 10) {
                if (map[discount[j]] != null) {
                    map[discount[j]] = map[discount[j]]!! - 1
                }
            }

            val hasAllZero = map.values.count { it != 0 } == 0
            if (hasAllZero) {
                answer++
            }
        }

        return answer
    }
}
