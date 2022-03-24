package study.leetcode

// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value
object SmallestString {
    fun getSmallestString(n: Int, k: Int): String {
        val result = StringBuilder()
        var count = n
        var value = k
        while (count != 0) {
            val max = 26 * (count-1)
            if (max >= value) {
                result.append( "a")
                value--
            } else {
                result.append((value - max + 96).toChar())
                value = max
            }
            count--
        }

        return result.toString()
    }
}


fun main() {
    val result = SmallestString.getSmallestString(5, 130)
    println(result)
}

// "D zzzzz zzzzz zzzzz zzzzz z"
// "aa vzzzz zzzzz zzzzz zzzzz"

// "aaaaa aaaaa aaaaa aaaaa aaaaa
// aaaaa aaaaa aaaaa aaaaa aaaaa
// aaaaa aaaaa vzzzzzzzzzzzzzzzzzzz"