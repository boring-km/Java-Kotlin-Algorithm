package study.leetcode.dfs

object FindClosestNodeToGivenTwoNodes {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {

        val n = edges.size

        val left = IntArray(n) {Int.MAX_VALUE}
        val right = IntArray(n) {Int.MAX_VALUE}

        left[node1] = 0
        right[node2] = 0

        // node1, node2 둘다 탐색해보기
        dfs(edges, BooleanArray(n), node1, left)
        dfs(edges, BooleanArray(n), node2, right)

        var min = -1
        var now = Int.MAX_VALUE

        for (i in 0 until n) {
            // 최대한 많이 이동한 노드 (최대 거리)
            val max = left[i].coerceAtLeast(right[i])
            if (now > max) {
                min = i // 그 노드 위치 기록
                now = max   // 다음엔 이 숫자보다 작아야 통과 됨 -> 그 중에 제일 작은 인덱스
            }
        }

        return min
    }

    private fun dfs(edges: IntArray, visited: BooleanArray, cur: Int, arr: IntArray) {
        visited[cur] = true // 방문 표시
        val next = edges[cur] // 다음 노드
        // 다음으로 연결되어 있고, 아직 방문하지 않은 곳이라면
        if (next != -1 && !visited[next]) {
            arr[next] = arr[cur] + 1        // 현재보다 한 칸 더 이동
            dfs(edges, visited, next, arr)  // 다음 노드 탐색
        }
    }
}

fun main() {
    val result = FindClosestNodeToGivenTwoNodes.closestMeetingNode(intArrayOf(2,2, 3, -1), 0, 1)
    println(result)
}