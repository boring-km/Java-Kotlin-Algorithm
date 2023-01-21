package study.leetcode.backtracking

import java.util.Deque
import java.util.LinkedList

object RestoreIpAddress {

    val result = mutableListOf<String>()
    val cur:Deque<String> = LinkedList()
    fun restoreIpAddresses(s: String): List<String> {

        if (s.length < 4 || s.length > 12) return result

        dfs(0, 4, s)

        return result
    }

    private fun dfs(i: Int, point: Int, s: String) {
        val n = s.length
        if (point == 0) {
            if (i == n) {
                result.add(cur.joinToString(separator = "."))
            }
            return
        }
        for (k in i until Math.min(i + 3, n)) {
            val str = s.substring(i, k + 1)
            if (point * 3 < s.substring(k).length || (str[0] == '0' && str.length > 1) || str.toInt() > 255) return
            cur.add(str)
            dfs(k+1, point-1, s)
            cur.removeLast()
        }
    }
}

fun main() {
    val result = RestoreIpAddress.restoreIpAddresses("25525511135")
    result.forEach { println(it) }
}