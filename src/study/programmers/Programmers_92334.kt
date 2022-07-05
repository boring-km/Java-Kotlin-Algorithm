package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=kotlin
object Programmers_92334 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val map = HashMap<String, HashSet<String>>()
        val answerMap = HashMap<String, Int>()

        id_list.forEach { answerMap[it] = 0 }
        report.forEach {
            val s = it.split(" ")
            if (map.containsKey(s[1])) {
                map[s[1]]!!.add(s[0])
            } else {
                map[s[1]] = HashSet()
                map[s[1]]!!.add(s[0])
            }
        }

        for (key in map.keys) {
            if (map[key]!!.size >= k) {
                for (value in map[key]!!) {
                    answerMap[value] = answerMap[value]!! + 1
                }
            }
        }

        for (i in id_list.indices) {
            val id = id_list[i]
            answer[i] = answerMap[id]!!
        }

        return answer
    }
}

fun main() {
    val result = Programmers_92334.solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
        2
    )

    result.forEach { println(it) }
}