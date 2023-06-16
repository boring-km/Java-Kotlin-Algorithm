package study.programmers

object Programmers_172928 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var x = 0; var y = 0
        val h = park.size
        val w = park[0].length

        // E, S, W, N
        val move = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val map = HashMap<String, IntArray>()
        map["E"] = move[0]
        map["S"] = move[1]
        map["W"] = move[2]
        map["N"] = move[3]

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (park[i][j] == 'S') {
                    y = i; x = j
                    break
                }
            }
        }

        for (route in routes) {
            val array = route.split(" ")
            val direction = array[0]
            val dist = array[1].toInt()
            val dy = y
            val dx = x

            for (i in 0 until dist) {
                val ty = y + map[direction]!![0]
                val tx = x + map[direction]!![1]

                if (tx in 0 until w && ty in 0 until h && (park[ty][tx] != 'X')) {
                    x = tx
                    y = ty
                } else {
                    x = dx
                    y = dy
                    break
                }
            }
        }

        return intArrayOf(y, x)
    }
}