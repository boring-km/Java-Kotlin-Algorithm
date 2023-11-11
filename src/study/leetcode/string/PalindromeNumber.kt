package study.leetcode.string

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val arr = x.toString()
        val target = arr.toCharArray().reversed().joinToString("")
        return arr == target
    }
}