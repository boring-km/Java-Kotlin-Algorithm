package study.programmers

object Programmers_138476 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        val map = HashMap<Int, Int>()
        tangerine.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        // map 안의 요소 중 큰 순서대로 정렬한 2차원 리스트
        val sorted = map.toList().sortedByDescending { (_, value) -> value }

        var count = k

        for (i in sorted.indices) {
            if (count == 0) return answer
            answer++
            for (j in 0 until sorted[i].second) {
                if (count != 0) {
                    count--
                } else {
                    return answer
                }
            }
        }

        return answer
    }
}

fun main() {
    println(Programmers_138476.solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}