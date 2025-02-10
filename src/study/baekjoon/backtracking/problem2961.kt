package study.baekjoon.backtracking

fun main() {
    val n = readLine()!!.toInt()
    val ingredients = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    var min = Int.MAX_VALUE

    fun dfs(index: Int, sour: Int, bitter: Int) {
        if (index == n) {
            if (sour == 1 && bitter == 0) return
            min = min.coerceAtMost(Math.abs(sour - bitter))
            return
        }

        // 현재 인덱스 재료 사용하고, 다음 인덱스 탐색
        dfs(index + 1, sour * ingredients[index][0], bitter + ingredients[index][1])

        // 현재 인덱스의 재료 사용하지 않고, 다음 인덱스 탐색
        dfs(index + 1, sour, bitter)
    }

    dfs(0, 1, 0)
    println(min)
}
