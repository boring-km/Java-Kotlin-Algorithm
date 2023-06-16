package study.programmers

// 실패: 정답률 75%
object Programmers_172928 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        // E, S, W, N
        val move = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

        var sy = 0
        var sx = 0
        var ySize = park.size
        var xSize = park[0].length

        for (y in 0 until ySize) {
            for (x in 0 until xSize) {
                if (park[y][x] == 'S') {
                    sy = y
                    sx = x
                    break
                }
            }
        }

        for (route in routes) {
            val t = route.split(" ")
            val direction = t[0]
            val dist = t[1]
            val arr = movement(direction, move)

            val yDist = arr[0] * dist.toInt()
            val xDist = arr[1] * dist.toInt()
            val ty = sy + yDist
            val tx = sx + xDist

            if (ty in 0 until ySize && tx in 0 until xSize) {
                var check = true
                // x
                if (xDist != 0) {
                    for (i in 1..xDist) {
                        if (park[sy][sx + i] != 'O') {
                            check = false
                            break
                        }
                    }
                }
                // y
                if (yDist != 0) {
                    for (i in 1..yDist) {
                        if (park[sy + i][sx] != 'O') {
                            check = false
                            break
                        }
                    }
                }
                if (check) {
                    sy = ty
                    sx = tx
                }
            }
        }

        return intArrayOf(sy, sx)
    }

    fun movement(text: String, move: Array<IntArray>): IntArray {
        return when(text) {
            "E" -> move[0]
            "S" -> move[1]
            "W" -> move[2]
            "N" -> move[3]
            else -> throw Exception()
        }
    }
}