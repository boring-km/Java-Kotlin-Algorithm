package study.leetcode.new2023

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BinaryTreePreorderTraversalTest {

    @Test
    @DisplayName("1,2,3 전위 순회")
    fun test1() {

        val target = TreeNode(1)
        target.left = null
        target.right = TreeNode(2)
        target.right!!.left = TreeNode(3)

        val result = BinaryTreePreorderTraversal.preorderTraversal(target)
        assertArrayEquals(result.toIntArray(), intArrayOf(1,2,3))

    }

    @Test
    @DisplayName("비어 있을 때")
    fun test2() {

        val target = null

        val result = BinaryTreePreorderTraversal.preorderTraversal(target)
        assertArrayEquals(result.toIntArray(), intArrayOf())

    }
}