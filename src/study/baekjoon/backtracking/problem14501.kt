package study.baekjoon.backtracking

fun main() {
    val n = readLine()!!.toInt()
    val tp = Array(n) { IntArray(2)}
    repeat(n) {
        val (t, p) = readLine()!!.split(" ").map { it.toInt() }
        tp[it][0] = t
        tp[it][1] = p
    }

    var answer = 0

    fun dfs(index: Int, price: Int) {
        if (index == n || index + tp[index][0] > n) {
            answer = answer.coerceAtLeast(price)
            if (index + 1 < n) {
                dfs(index + 1, price)
            }
            return
        }

        // 상담을 한다면
        dfs(index + tp[index][0], price + tp[index][1])
        // 상담을 안한다면
        dfs(index + 1, price)

    }

    dfs(0, 0)

    println(answer)
}