fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    
    val first = Array(n) {IntArray(n)}
    val board = Array(n) {IntArray(n)}

    for (i in 0 until n) {
        val rl = readLine()!!.split(" ").map { it.toInt() }
        for (j in 0 until n) {
            board[i][j] = rl[j]
            first[i][j] = rl[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == 0 && j != 0) {
                board[i][j] += board[i][j-1] 
            } else if (i != 0 && j == 0) {
                board[i][j] += board[i-1][j]
            } else if (i != 0 && j != 0) {
                board[i][j] += board[i-1][j] + board[i][j-1] - board[i-1][j-1]
            }
        }
    }

    for (i in 0 until m) {
        val (y1, x1, y2, x2) = readLine()!!.split(" ").map { it.toInt() -1 }
        var extra = 0
        if (x1 > 0) {
            extra += board[y2][x1-1]
        }
        if (y1 > 0) {
            if (extra != 0) {
                extra -= board[y1-1][x1-1]
            }
            extra += board[y1-1][x2]
        }
        println(board[y2][x2] - extra)
    }
    
}