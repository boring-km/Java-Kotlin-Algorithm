package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
object Programmers_87946 {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size) { false }
        var max = 0

        for (i in dungeons.indices) {
            max = Math.max(max, mydfs(k, 0, i, dungeons, visited.clone()))
        }

        return max
    }

    private fun mydfs(left: Int, count: Int, i: Int, dungeons: Array<IntArray>, visited: BooleanArray): Int {
        var index = i
        if (i == dungeons.size) {
            for (k in 0 until i) {
                if (!visited[k]) {
                    index = k
                    break
                }
            }
        }
        if (count >= dungeons.size || index >= dungeons.size || left <= 0) {
            return count
        }
        val dungeon = dungeons[index]
        if (left >= dungeon[0] && !visited[index]) {
            visited[index] = true
            return Math.max(mydfs(left - dungeon[1], count+1, index+1, dungeons, visited.clone()), mydfs(left, count+1, index+1, dungeons, visited))
        } else {
            return mydfs(left, count+1, index+1, dungeons, visited.clone())
        }
    }


}

fun main() {
    val result = Programmers_87946.solution(
        80,
        arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
    )
    println(result)
}