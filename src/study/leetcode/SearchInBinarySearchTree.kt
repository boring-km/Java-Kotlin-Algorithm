package study.leetcode

// https://leetcode.com/problems/search-in-a-binary-search-tree/
object SearchInBinarySearchTree {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {

        var copy = root

        while (copy?.`val` != null) {
            if (copy.`val` == `val`) {
                return copy
            } else if (copy.`val` < `val`) {
                copy = copy.right
            } else {
                copy = copy.left
            }
        }

        return copy
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
