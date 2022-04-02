package study.leetcode

// https://leetcode.com/problems/longest-substring-without-repeating-characters
object LongestSubstringWithoutRepeating {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        var current = ""

        for (ch: Char in s) {
            if (current.isEmpty()) {
                current += ch
                continue
            }

            if (current.last() == ch) {
                result = getMaxResult(result, current.length)
                current = ch.toString()
                continue
            }

            if (ch in current) {
                for (i in current.indices) {
                    if (current[i] == ch) {
                        result = getMaxResult(result, current.length)
                        current = current.substring(i+1) + ch
                        break
                    }
                }
                continue
            }

            current += ch

            if (current.length % 2 == 0) {
                if (current.substring(0, current.length / 2) == current.substring(current.length / 2)) {
                    result = getMaxResult(result, current.length / 2)
                    current = ""
                }
            }
        }
        result = getMaxResult(result, current.length)

        return result
    }

    private fun getMaxResult(result: Int, currentLength: Int): Int {
        var result1 = result
        result1 = Math.max(result1, currentLength)
        return result1
    }

}

fun main() {
    val result = LongestSubstringWithoutRepeating.lengthOfLongestSubstring("dvdf")
    println(result)
}