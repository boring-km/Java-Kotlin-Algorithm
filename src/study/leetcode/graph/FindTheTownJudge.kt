package study.leetcode.graph

object FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {

        if (trust.isEmpty()) return if (n == 1) 1 else -1

        val count = IntArray(n + 1)
        for (person in trust) {
            count[person[0]]--
            count[person[1]]++
        }

        for (person in count.indices) {
            if (count[person] == n - 1) return person
        }
        return -1
    }
}

fun main() {
    val result = FindTheTownJudge.findJudge(2, arrayOf(intArrayOf(1,2), intArrayOf(2,1)))
    println(result)
}