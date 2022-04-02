package study.leetcode

// https://leetcode.com/problems/valid-palindrome-ii/
object ValidPalindrome2 {

    // 문제의 좌표부터 확인
    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        val mid = (end - start) / 2
        for (j in 0..mid) {
            if (s[start + j] != s[end - j]) {
                return false
            }
        }
        return true
    }

    fun validPalindrome(s: String): Boolean {
        for (i in 0 until s.length / 2) {   // 앞에 절반
            if (s[i] != s[s.length - 1 - i]) {  // 뒤에서 부터 비교해서 값이 다르면?
                val end = s.length - 1 - i    // 뒤에 좌표
                return isPalindrome(s, i + 1, end) ||  // 그 다음 좌표
                        isPalindrome(s, i, end - 1)    // 그 다음 좌표
            }
        }
        return true
    }
}

fun main() {
    println(ValidPalindrome2.validPalindrome("cbbcc"))
}