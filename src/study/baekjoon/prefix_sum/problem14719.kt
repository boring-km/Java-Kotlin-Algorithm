fun main() {
    val firstLine = readLine()!!.split(" ").map { it.toInt() }
    val h = firstLine[0]
    val w = firstLine[1]

    val board = Array(502) { BooleanArray(502) }

    val secondLine = readLine()!!.split(" ").map { it.toInt() }
    for (i in 0 until secondLine.size) {
        for (j in 1 .. secondLine[i]) {
            board[j][i] = true
        }
    }

    var answer = 0
    for (i in 0..500) {
        var start = -1
        var count = 0
        for (j in 0..500) {
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
    
    println(answer - secondLine.sum())
}