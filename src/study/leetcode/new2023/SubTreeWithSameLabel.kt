package study.leetcode.new2023

object SubTreeWithSameLabel {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {

        val answer = IntArray(n)
        val board = Array(n) { mutableListOf<Int>()}

        for (edge in edges) {
            board[edge[0]].add(edge[1])
            board[edge[1]].add(edge[0])
        }

        dfs(board, 0, -1, labels, answer)

        return answer
    }

    private fun dfs(board: Array<MutableList<Int>>, cur: Int, parent: Int, labels: String, ans: IntArray): IntArray {
        val count = IntArray(26)
        for (item in board[cur]) {
            if (item == parent) continue    // 같은 건 패스
            val childCount = dfs(board, item, cur, labels, ans)
            for (i in 0..25) {
                count[i] += childCount[i]
            }
        }
        // leetcode에서는 .toByte().toInt()
        ans[cur] = ++count[labels[cur].code - 'a'.code]
        return count
    }
}