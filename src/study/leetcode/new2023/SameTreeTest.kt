package study.leetcode.new2023

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SameTreeTest {

    @Test
    fun isSameTree() {
        val p = SameTree.TreeNode(1)
        val q = SameTree.TreeNode(1)

        p.left = SameTree.TreeNode(2)
        p.right = SameTree.TreeNode(3)

        q.left = SameTree.TreeNode(2)
        q.right = SameTree.TreeNode(3)

        assertTrue(SameTree.isSameTree(p, q))
    }
}