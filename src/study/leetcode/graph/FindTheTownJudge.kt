package study.leetcode.graph

object FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {

        if (trust.isEmpty()) {
            return if (n == 1) 1 else -1
        }

        val graph = Array(n + 1) { BooleanArray(n + 1) }

        for (item in trust) {
            graph[item[1]][item[0]] = true
        }

        for (i in graph.indices) {
            var cur = 0

            for (j in graph[i].indices) {
                if (graph[i][j]) {
                    cur++
                }
            }

            if (cur == n-1) {
                var trustSomeone = false
                for (j in 0 .. n) {
                    if (graph[j][i]) {
                        trustSomeone = true
                        break
                    }
                }
                if (trustSomeone) {
                    continue
                } else {
                    return i
                }
            }
        }

        return -1
    }
}

fun main() {
    val result = FindTheTownJudge.findJudge(2, arrayOf(intArrayOf(1,2), intArrayOf(2,1)))
    println(result)
}