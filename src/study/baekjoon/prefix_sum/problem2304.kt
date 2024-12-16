import kotlin.text.toInt
import kotlin.collections.mutableListOf

fun main() {
    val n = readLine()!!.toInt()
    val board = Array(1001) { BooleanArray(1001) }
    for (i in 1..n) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        for (j in 1..line[1]) {
            board[j][line[0]] = true
        }
    }

    var answer = 0
    for (i in 0..1000) {
        var start = -1
        var count = 0
        for (j in 0..1000) {
            if (board[i][j] && start == -1) {
                start = j
            }
            if (board[i][j] && start != -1) {
                count = j
            }
        }
        if (start != -1) {
            answer += (count - start + 1)
        }
    }
    println(answer)
}
