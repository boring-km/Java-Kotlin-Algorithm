package study.leetcode.new2023

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaxPointsOnALIneTest {
    @Test
    @DisplayName("가장 긴 일직선 찾기")
    fun test() {
        val result = MaxPointsOnALIne.maxPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(3, 2),
                intArrayOf(5, 3),
                intArrayOf(4, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 4)
            )
        )
        assertEquals(result, 4)
    }
}