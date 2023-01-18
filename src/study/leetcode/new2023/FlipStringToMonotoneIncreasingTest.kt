package study.leetcode.new2023

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FlipStringToMonotoneIncreasingTest {

    @Test
    fun minFlipsMonoIncr() {
        val result = FlipStringToMonotoneIncreasing.minFlipsMonoIncr("0101100011")
        assertEquals(3, result)
    }

    @Test
    fun test11011() {
        val result = FlipStringToMonotoneIncreasing.minFlipsMonoIncr("11011")
        assertEquals(1, result)
    }

    @Test
    fun test10011111110010111011() {
        val result = FlipStringToMonotoneIncreasing.minFlipsMonoIncr("10011111110010111011")
        assertEquals(5, result)
    }
}