package study.leetcode

class SmallestString {
    fun getSmallestString(n: Int, k: Int): String {

        var maxCount = k / 26   // 27 / 26 => 1
        var maxNormalCount = n - maxCount   // 3 - 1 => 2
        if (maxNormalCount >= 26) {
            val overCount = maxNormalCount / 26
            maxCount -= overCount
            maxNormalCount += overCount
        }

        val zCount = if (k < maxCount * 26 + maxNormalCount) maxCount - 1 else maxCount

        val normalCount = n - zCount
        val maxValue = zCount * 26

        if (normalCount == 0) return "z" * n

        val smallestCount = normalCount - 1
        var second = (k - maxValue) - smallestCount
        if (zCount == 0) {
            second = k - smallestCount
        }

        var result = ""

        if (normalCount == 1) {
            result += (second + 96).toChar()
        } else {
            result += "a" * smallestCount
            result += (second + 96).toChar()
        }

        result += "z" * zCount
         return result
    }

    private operator fun String.times(n: Int): String {
        var result = ""
        for (i in 0 until n) result += this
        return result
    }
}


fun main() {
    val result = SmallestString().getSmallestString(23100, 567226)
    println(result)
}

// "D zzzzz zzzzz zzzzz zzzzz z"
// "aa vzzzz zzzzz zzzzz zzzzz"

// "aaaaa aaaaa aaaaa aaaaa aaaaa
// aaaaa aaaaa aaaaa aaaaa aaaaa
// aaaaa aaaaa vzzzzzzzzzzzzzzzzzzz"