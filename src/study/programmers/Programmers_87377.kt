package study.programmers

private object Programmers_87377 {
    fun solution(line: Array<IntArray>): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        var listX = arrayListOf<DoubleArray>()
        var listY = arrayListOf<DoubleArray>()
        for (g in line) {
            var a = g[0].toDouble() // 0
            var b = g[1].toDouble() // -1
            var c = g[2].toDouble() // 1

            var y1 = if (g[0] != 0) -(b / a) else 0.0
            var y2 = -(c / a)
            var x1 = if (g[1] != 0) -(a / b) else 0.0
            var x2 = -(c / b)

            listX.add(doubleArrayOf(y1, y2))
            listY.add(doubleArrayOf(x1, x2))

        }
        // ax + by + c = 0
        // -(a1/b1)x - (c1/b1) = y
        // -(a2/b2)x - -(a1/b1)x = - (c1/b1) - - (c2/b2)
        val visited = HashMap<Int, Int>()
        val ic = arrayListOf<IntArray>()
        for (i in listY.indices) {
            for (j in listY.indices) {
                if (i != j) {
                    val ya1 = listY[i][0]
                    val ya2 = listY[i][1]
                    val yb1 = listY[j][0]
                    val yb2 = listY[j][1]
                    val xa1 = listX[i][0]
                    val xa2 = listX[i][1]
                    val xb1 = listX[j][0]
                    val xb2 = listX[j][1]

                    val tx = if (ya1 != yb1) (yb2 - ya2) / (ya1 - yb1) else (yb2 - ya2)
                    val ty = if (xa1 != xb1) (xb2 - xa2) / (xa1 - xb1) else (xb2 - xa2)
                    if ((tx == tx.toInt().toDouble())
                        && ty == ty.toInt().toDouble()
                        && visited.getOrDefault(tx.toInt(), 100001) != ty.toInt()
                    ) {
                        ic.add(intArrayOf(tx.toInt(), ty.toInt()))
                        visited[tx.toInt()] = ty.toInt()
                    }
                }
            }
        }
        for (item in ic) {
            item.forEach { print("$it, ") }
            println()
        }

        return answer
    }
}

fun main() {
    val result = Programmers_87377.solution(
        arrayOf(
            intArrayOf(2, -1, 4),
            intArrayOf(-2, -1, 4),
            intArrayOf(0, -1, 1),
            intArrayOf(5, -8, -12),
            intArrayOf(5, 8, 12)
        )
    )
    result.forEach { println(it) }
}

/*

 */