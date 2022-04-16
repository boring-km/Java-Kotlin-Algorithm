package study.leetcode

// https://leetcode.com/problems/trim-a-binary-search-tree/
object TrimBinarySearchTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        if (root == null) return null   // 탐색 종료
        if (root.`val` < L) return trimBST(root.right, L, R)    // 최솟값보다 더 작은 값이면 자르기
        if (root.`val` > R) return trimBST(root.left, L, R)     // 최댓값보다 더 큰 값이면 자르기
        root.left = trimBST(root.left, L, R)    // 다음 왼쪽 값
        root.right = trimBST(root.right, L, R)  // 다음 오른쪽 값
        return root
    }
}