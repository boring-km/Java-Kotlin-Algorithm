package study.programmers.dfsbfs

private object Programmers_12952 {
    fun solution(n: Int): Int {
        return dfs(0, n, IntArray(n))
    }

    fun dfs(x: Int, n: Int, arr: IntArray): Int {
        var result = 0

        // n까지 전부 탐색했을 때
        if (x == n) return 1

        // n개를 둬야한다.
        for (y in 0 until n) {
            // Queen을 둘 수 있다면 다음 경로를 탐색
            if (canBeQueen(x, y, x, arr)) {
                arr[x] = y
                result += dfs(x+1, n, arr)
            }
        }

        return result
    }

    fun canBeQueen(x: Int, y: Int, n: Int, arr: IntArray): Boolean {
        for (i in 0 until x) {
            if (y == arr[i] || Math.abs(y - arr[i]) == x - i) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val result = Programmers_12952.solution(8)
    println(result)
}