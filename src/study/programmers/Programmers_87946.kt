package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
object Programmers_87946 {

    private var answer = 0
    private lateinit var visited: BooleanArray
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size){false}
        dfs(0, k, dungeons)
        return answer
    }

    private fun dfs(depth: Int, k: Int, dungeons: Array<IntArray>) {
        for (i in dungeons.indices) {
            // 아직 방문하지 않았고, 최소 피로도 만족할 때
            if (!visited[i] && dungeons[i][0] <= k) {
                // 방문
                visited[i] = true
                // 다음 depth, 피로도 소비
                dfs(depth+1, k-dungeons[i][1], dungeons)
                // 다른 방법을 위해 방문 초기화
                visited[i] = false
            }
        }
        answer = Math.max(answer, depth)
    }

}

fun main() {
    val result = Programmers_87946.solution(
        80,
        arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
    )
    println(result)
}