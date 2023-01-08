package study.leetcode.new2023

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LongestCommonPrefixTest {
    @Test
    @DisplayName("가장 긴 prefix 구하기")
    fun testLongestCommonPrefix() {

        val result1 = LongestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
        assertEquals(result1, "fl")

        val result2 = LongestCommonPrefix.longestCommonPrefix(arrayOf("ab", "a"))
        assertEquals(result2, "a")

        val result3 = LongestCommonPrefix.longestCommonPrefix(arrayOf("a"))
        assertEquals(result3, "a")

        val result4 = LongestCommonPrefix.longestCommonPrefix(arrayOf("flower","flower","flower","flower"))
        assertEquals(result4, "flower")
    }

    @Test
    @DisplayName("가장 긴 prefix 구하기 - 일치 없을 때")
    fun testFailLongestCommonPrefix() {

        val result = LongestCommonPrefix.longestCommonPrefix(arrayOf("dog","racecar","car"))
        assertEquals(result, "")

    }
}
