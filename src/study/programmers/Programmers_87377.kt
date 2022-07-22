package study.programmers

private object Programmers_87377 {
    fun solution(line: Array<IntArray>): Array<String> {
        val n = line.size
        val inf = Long.MAX_VALUE
        val list = arrayListOf<LongArray>()
        var minX = inf
        var minY = inf
        var maxX = -inf
        var maxY = -inf

        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                val a = line[i][0].toLong()
                val b = line[i][1].toLong()
                val e = line[i][2].toLong()
                val c = line[j][0].toLong()
                val d = line[j][1].toLong()
                val f = line[j][2].toLong()

                val mod = a * d - b * c
                if (mod == 0L) continue

                val tx = b * f - e * d
                val ty = e * c - a * f
                if (tx % mod != 0L || ty % mod != 0L) continue

                val x = tx / mod
                val y = ty / mod

                list.add(longArrayOf(x, y))
                minX = Math.min(minX, x)
                minY = Math.min(minY, y)
                maxX = Math.max(maxX, x)
                maxY = Math.max(maxY, y)
            }
        }

        val paper = Array((maxY - minY + 1).toInt()) { CharArray((maxX - minX + 1).toInt()) { '.' } }
        list.forEach {
            val y = it[1]
            val x = it[0]
            paper[(maxY - y).toInt()][(x - minX).toInt()] = '*'
        }
        val answer: Array<String> = Array(paper.size) { "" }

        for (i in paper.indices) {
            var temp = ""
            paper[i].forEach { temp += it }
            answer[i] = temp
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