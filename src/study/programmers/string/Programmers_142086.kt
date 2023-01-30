package study.programmers.string

object Programmers_142086 {
    fun solution(s: String): IntArray {
        val map = HashMap<String, Int>()

        val result = mutableListOf<Int>()
        val arr = s.toCharArray()
        for (i in arr.indices) {
            val c = arr[i].toString()
            if (map.containsKey(c)) {
                result.add(i - map[c]!!)
                map[c] = i
            } else {
                result.add(-1)
                map[c] = i
            }
        }

        return result.toIntArray()
    }
}

fun main() {
    val result = Programmers_142086.solution("banana")
    result.forEach { println(it) }
}