package study.leetcode

class CountOddNumbersIntervalRange {
    fun countOdds(low: Int, high: Int): Int {
        var result = if (high % 2 != 0) {
            (high + 1) / 2
        } else {
            high / 2
        }

        result -= if (low % 2 != 0) {
            (low + 1) / 2 - 1
        } else {
            low / 2
        }

        return result
    }
}


// 2 3 5 7 11 13
// 1 2 3 4 5  6