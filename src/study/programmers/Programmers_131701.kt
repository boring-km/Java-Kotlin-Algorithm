package study.programmers

object Programmers_131701 {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0
        val n = elements.size

        val newArray = IntArray(n + n - 1)
        for (i in elements.indices) {
            newArray[i] = elements[i]
        }
        for (i in 0 until n - 1) {
            newArray[i + n] = elements[i]
        }

        val map = HashMap<Int, Boolean>()

        for (start in 0 until n) {
            var cur = newArray[start]
            if (!map.containsKey(cur)) {
                map[cur] = true
                answer++
            }
            for (end in start + 1 until start + n) {
                cur += newArray[end]
                if (map.containsKey(cur)) continue
                else {
                    map[cur] = true
                    answer++
                }
            }
        }

        return answer
    }
}

fun main() {
    println(Programmers_131701.solution(intArrayOf(7, 9, 1, 1, 4)))
}