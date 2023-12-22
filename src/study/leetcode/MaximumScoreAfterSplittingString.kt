package study.leetcode

object MaximumScoreAfterSplittingString {
    fun maxScore(s: String): Int {
        var max = 0

        for (i in 1 until s.length) {
            val left = s.substring(0, i).count { it == '0' }
            val right = s.substring(i).count { it == '1' }
            max = maxOf(max, left + right)
        }

        return max
    }
}