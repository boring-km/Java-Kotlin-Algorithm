package study.leetcode.backtracking

import java.util.Deque
import java.util.LinkedList

object RestoreIpAddress {

    val result = mutableListOf<String>()
    val cur: Deque<String> = LinkedList()
    fun restoreIpAddresses(s: String): List<String> {

        if (s.length < 4 || s.length > 12) return result

        // 0부터 시작, 남은 점은 4개
        dfs(0, 4, s)

        return result
    }

    private fun dfs(i: Int, point: Int, s: String) {
        val n = s.length
        // 찍을 점이 없다면,
        if (point == 0) {
            // 마지막 문자열에서 그동안 큐에 담긴 문자열에 . 붙이기
            if (i == n) {
                result.add(cur.joinToString(separator = "."))
            }
            return
        }

        // 현재 위치부터 다음 점 찍기 전까지, 그리고 n을 넘으면 안됨 (문자열 끝)
        for (p in i until Math.min(i + 3, n)) {
            // 현재 위치에서 다음 점 찍기 전까지 남은 갯수만큼 문자열 자르기
            val str = s.substring(i, p + 1)
            // 예외 조건: 12개보다 더 길면 x, 시작이 0으로 시작하는 두자리 이상 값 x, 255 넘으면 x
            if (12 < s.substring(p).length ||
                (str[0] == '0' && str.length > 1) ||
                str.toInt() > 255
            ) return

            cur.add(str)
            // 다음 위치, 점 갯수 소모
            dfs(p + 1, point - 1, s)
            cur.removeLast()
        }
    }
}

fun main() {
    val result = RestoreIpAddress.restoreIpAddresses("25525511135")
    result.forEach { println(it) }
}