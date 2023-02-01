package study.leetcode.string

// 모범 답안
object GreatestCommonDivisorStrings {
    // 최대공약수 구하기
    private fun gcd(x: Int, y: Int): Int {
        return if (y == 0) {
            x
        } else {
            gcd(y, x % y)
        }
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        // Check if they have non-zero GCD string. ex) LEET, CODE
        // 앞뒤가 바뀌어도 붙이면 같아야함
        if (str1 + str2 != str2 + str1) {
            return ""
        }

        // Get the GCD of the two lengths.
        val gcdLength = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLength)
    }
}