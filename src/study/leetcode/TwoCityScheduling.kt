package study.leetcode

import kotlin.math.abs

// https://leetcode.com/problems/two-city-scheduling/
object TwoCityScheduling {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        var result = 0
        val size = costs.size
        var left = size / 2
        var right = size / 2

        costs.sortWith(Comparator {  arr1, arr2 -> abs(arr2[0] - arr2[1]) - abs(arr1[0] - arr1[1])  })

        for (arr in costs) {
            if (arr[0] < arr[1]) {
                if (left > 0) {
                    left--
                    result += arr[0]
                } else {
                    right--
                    result += arr[1]
                }
            } else {
                if (right > 0) {
                    right--
                    result += arr[1]
                } else {
                    left--
                    result += arr[0]
                }
            }
        }

        return result
    }

}

fun main() {
    val result = TwoCityScheduling.twoCitySchedCost(
        arrayOf(
            intArrayOf(259, 770), // 511 L -
            intArrayOf(448, 54), // 394 R
            intArrayOf(926, 667), // 259 R
            intArrayOf(184, 139), // 45 R
            intArrayOf(840, 118), // 722 R -
            intArrayOf(577, 469) // 108 R
        )
    )
    println(result)
}

