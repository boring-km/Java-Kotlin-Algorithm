package study.leetcode

object ReverseString {
    fun reverseString(s: CharArray): Unit {
        return s.reverse()
    }
}

fun main() {
    ReverseString.reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
}