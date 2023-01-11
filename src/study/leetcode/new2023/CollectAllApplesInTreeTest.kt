package study.leetcode.new2023

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CollectAllApplesInTreeTest {

    @Test
    fun minTime() {
        val result = CollectAllApplesInTree.minTime(
                7,
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false)
        )
        assertEquals(8, result)
    }
}