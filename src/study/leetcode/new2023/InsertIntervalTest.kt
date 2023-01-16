package study.leetcode.new2023

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InsertIntervalTest {

    @Test
    fun insert() {
        val result = InsertInterval.insert(arrayOf(intArrayOf(1,5)), intArrayOf(0,0))
        assertArrayEquals(arrayOf(intArrayOf(0,0), intArrayOf(1,5)), result)
    }
}