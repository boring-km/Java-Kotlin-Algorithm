package study.leetcode

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
object KthSmallestElementInBST {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val sorted = recursive(root, null)
        val result = findSmall(sorted, k)
        return result
    }

    private fun findSmall(node: TreeNode?, k: Int): Int {
        if (k == 1) {
            return node?.`val`!!
        }
        else {
            return findSmall(node?.right, k-1)
        }
    }

    private fun recursive(root: TreeNode?, tail: TreeNode?): TreeNode? {
        if (root == null) return tail       // 탐색이 끝났다면 tail을 return
        val tree = recursive(root.left, root)    // 왼쪽으로 계속 탐색 tail은 이전까지의 Node
        root.left = null    // left는 채우지 않음
        root.right = recursive(root.right, tail)    // 이전 노드를 오른쪽에 채움
        return tree
    }
}