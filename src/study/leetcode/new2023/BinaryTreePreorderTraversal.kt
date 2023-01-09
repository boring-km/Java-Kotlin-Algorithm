package study.leetcode.new2023
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
object BinaryTreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        dfs(root, result)

        return result
    }

    private fun dfs(node: TreeNode?, list: MutableList<Int>) {
        if (node != null) {
            list.add(node.`val`)
            dfs(node.left, list)
            dfs(node.right, list)
        }
    }
}