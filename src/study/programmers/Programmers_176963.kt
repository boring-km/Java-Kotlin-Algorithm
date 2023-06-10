package study.programmers

object Programmers_176963 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer = IntArray(photo.size)

        val map = HashMap<String, Int>()

        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }

        for (i in photo.indices) {
            val array = photo[i]
            for (j in array.indices) {
                val target = array[j]
                val v = map.getOrDefault(target, 0)
                answer[i] += v
            }
        }

        return answer
    }
}

fun main() {
    val result = Programmers_176963.solution(
            arrayOf("may", "kein", "kain", "radi"),
            intArrayOf(5, 10, 1, 3),
            arrayOf(arrayOf("muzi", "frodo", "apeach", "neo"),
                    arrayOf("muzi", "frodo", "apeach", "neo")
            )
    )
    for (item in result) {
        print("$item ")
    }
}