package study.leetcode

// https://leetcode.com/problems/convert-bst-to-greater-tree/
object ConvertBSTGreaterTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun convertBST(root: TreeNode?): TreeNode? {
        convert(root)
        return root
    }

    var sum = 0

    private fun convert(cur: TreeNode?) {
        if (cur == null) return // 마지막 노드
        convert(cur.right)  // 오른쪽 끝부터 탐색
        cur.`val` += sum    // 전체 합을 현재 값에 더함
        sum = cur.`val`     // 현재 값을 다음 합으로 세팅
        convert(cur.left)   // 왼쪽 끝까지 탐색
    }
}

fun main() {

}