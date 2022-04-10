package study.leetcode

// 풀이: https://leetcode.com/problems/permutation-in-string/discuss/102588/Java-Solution-Sliding-Window
// https://leetcode.com/problems/permutation-in-string/
object PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val a = s1.length
        val b = s2.length

        if (a > b) return false

        val count = IntArray(26)
        for (i in 0 until a) {
            count[s1[i] - 'a']++    // s1 알파벳 마다 횟수 + 1
        }

        for (i in 0 until b) {
            count[s2[i] - 'a']--    // s2 a 보다 긴 길이에서 알파벳 횟수 - 1
            if (i - a >= 0) {
                count[s2[i-a] - 'a']++
            }

            if (allZero(count)) return true
        }

        return false
    }

    private fun allZero(count: IntArray): Boolean {
        for (i in 0 until 26) {
            if (count[i] != 0) return false
        }
        return true
    }
}

fun main() {
    println(PermutationInString.checkInclusion("ab", "aasefboadsa"))
}