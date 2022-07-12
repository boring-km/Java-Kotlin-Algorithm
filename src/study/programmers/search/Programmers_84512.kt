package study.programmers.search

private object Programmers_84512 {
    fun solution(word: String): Int {
        val sMap = mapOf(0 to 'X', 1 to 'A', 2 to 'E', 3 to 'I', 4 to 'O', 5 to 'U')
        val set = HashSet<String>()
        for (a in 0 until 6) {
            for (b in 0 until 6) {
                for (c in 0 until 6) {
                    for (d in 0 until 6) {
                        for (e in 0 until 6) {
                            set.add(String(charArrayOf(sMap[a]!!, sMap[b]!!, sMap[c]!!, sMap[d]!!, sMap[e]!!)).replace("X", ""))
                        }
                    }
                }
            }
        }
        var answer = 0
        val myList = set.toList().sorted()
        for (i in myList.indices) {
            if (myList[i] == word) {
                answer = i
                break
            }
        }
        return answer
    }
}

fun main() {
    val result = Programmers_84512.solution("EIO")
    println(result == 1189)
}