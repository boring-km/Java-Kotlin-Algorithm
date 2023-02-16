package study.leetcode.graph

object MaximumDepthBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxDepth(root: TreeNode?): Int {

        if (root != null) {
            return dfs(root, 1)
        }

        return 0
    }

    fun dfs(node: TreeNode?, cur: Int): Int {
        return if (node == null) cur
        else {

            var l = cur
            var r = cur
            if (node.left != null) {
                l = dfs(node.left, cur+1)
            }
            if (node.right != null) {
                r = dfs(node.right, cur+1)
            }
            return l.coerceAtLeast(r)
        }
    }
}
