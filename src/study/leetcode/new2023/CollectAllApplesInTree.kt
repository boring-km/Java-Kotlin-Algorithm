package study.leetcode.new2023


object CollectAllApplesInTree {

    val map = HashMap<Int, MutableList<Int>>()

    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {

        for (edge in edges) {
            if (map.containsKey(edge[0])) {
                map[edge[0]]!!.add(edge[1])
            } else {
                map[edge[0]] = mutableListOf(edge[1])
            }
            if (map.containsKey(edge[1])) {
                map[edge[1]]!!.add(edge[0])
            } else {
                map[edge[1]] = mutableListOf(edge[0])
            }
        }

        return dfs(0, hasApple, BooleanArray(n))
    }

    private fun dfs(cur: Int, hasApple: List<Boolean>, visited: BooleanArray): Int {
        visited[cur] = true
        var result = 0

        if (map[cur] == null) {
            return 0
        }

        for (next in map[cur]!!) {
            if (!visited[next]) {
                val depth = dfs(next, hasApple, visited)
                if (depth > 0 || hasApple[next]) {
                    result += depth + 2  // 한번 깊이가 들어갈 때 마다 되돌아 오는 거 생각해야 함
                }
            }
        }
        return result
    }
}