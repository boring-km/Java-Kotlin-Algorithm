package study.leetcode

object LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length <= 1) {
            return s
        }

        var start = 0
        var length = 0

        for (end in s.indices) {

            if (s.substring(end - length, end + 1) == s.substring(end - length, end + 1).reversed()) {
                start = end - length
                length++ // 하나씩
                println("first: ${s.substring(start, start + length)}")
            } else if (
                end - length - 1 + 1 > 0 &&
                s.substring(end - length - 1, end + 1) == s.substring(end - length - 1, end + 1).reversed()
            ) {
                start = end - length - 1
                length += 2 // 2개
                println("second: ${s.substring(start, start + length)}")
            }
        }

        return s.substring(start, start + length)
    }
}

fun main() {
    val result = LongestPalindromicSubstring.longestPalindrome("akabbddbbaak")
    println(result)
}