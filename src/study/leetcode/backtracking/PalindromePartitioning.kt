package study.leetcode.backtracking

import java.util.*

object PalindromePartitioning {

    val result = mutableListOf<MutableList<String>>()
    private val current: Deque<String> = LinkedList()
    fun partition(s: String): List<List<String>> {

        // 가장 긴 문자열 길이부터 펠린드롬 검사하기

        dfs(0, s)

        return result.toList()
    }

    private fun dfs(cur: Int, s: String) {

        if (cur == s.length) {
            result.add(current.toMutableList())
            return
        }

        for (j in cur until s.length) {
            if (palindrome(s, cur, j)) {
                current.add(s.substring(cur, j+1))
                dfs(j+1, s)
                current.removeLast()
            }
        }
    }

    private fun palindrome(s: String, left: Int, right: Int): Boolean {

        var l = left
        var r = right
        while (l < r) {
            if (s[l] != s[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}

fun main() {
    val result = PalindromePartitioning.partition("cdd")
    result.forEach { println(it) }
}