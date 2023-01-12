package study.leetcode.new2023

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SubTreeWithSameLabelTest {

    @Test
    fun countSubTrees() {
        val result1 = SubTreeWithSameLabel.countSubTrees(4, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3)), "bbbb")
        assertArrayEquals(result1, intArrayOf(4,2,1,1))

        val result2 = SubTreeWithSameLabel.countSubTrees(4, arrayOf(intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2)), "aeed")
        result2.forEach { println(it) }
        assertArrayEquals(result2, intArrayOf(1,1,2,1))
    }
}