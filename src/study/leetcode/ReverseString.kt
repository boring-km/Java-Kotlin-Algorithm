package study.leetcode

// https://leetcode.com/problems/reverse-string
object ReverseString {
    fun reverseString(s: CharArray): Unit {
        return s.reverse()
    }
}

fun main() {
    ReverseString.reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
}