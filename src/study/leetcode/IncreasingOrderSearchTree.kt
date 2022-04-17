package study.leetcode

// https://leetcode.com/problems/increasing-order-search-tree/
object IncreasingOrderSearchTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        return recursive(root, null)
    }

    private fun recursive(root: TreeNode?, tail: TreeNode?): TreeNode? {
        if (root == null) return tail       // 탐색이 끝났다면 tail을 return
        val tree = recursive(root.left, root)    // 왼쪽으로 계속 탐색 tail은 이전까지의 Node
        root.left = null    // left는 채우지 않음
        root.right = recursive(root.right, tail)    // 이전 노드를 오른쪽에 채움
        return tree
    }
}

fun main() {
    val node = IncreasingOrderSearchTree.TreeNode(5)
    node.left = IncreasingOrderSearchTree.TreeNode(3)
    node.left?.left = IncreasingOrderSearchTree.TreeNode(2)
    node.left?.right = IncreasingOrderSearchTree.TreeNode(4)
    node.left?.left?.left = IncreasingOrderSearchTree.TreeNode(1)
    val result = IncreasingOrderSearchTree.increasingBST(node)
    println("final")
}