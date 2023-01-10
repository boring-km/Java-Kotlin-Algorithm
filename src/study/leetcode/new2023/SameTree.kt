package study.leetcode.new2023


object SameTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return dfs(p, q)
    }

    private fun dfs(a: TreeNode?, b: TreeNode?): Boolean {

        return if (a == null && b == null) {
            true
        } else if (a == null || b == null) {
            false
        } else {
            a.`val` == b.`val` && dfs(a.left, b.left) && dfs(a.right, b.right)
        }
    }
}