package study.leetcode.new2023

import java.util.*

object MaximumSumCircularSubarray {
    fun maxSubarraySumCircular(nums: IntArray): Int {

        val n = nums.size

        var total = 0
        var min = 0
        var max = 0

        var minSum = nums[0]
        var maxSum = nums[0]
        var tempMax = -3 * 10000
        for (i in nums.indices) {
            tempMax = tempMax.coerceAtLeast(nums[i])
            min = (min + nums[i]).coerceAtMost(nums[i])
            minSum = minSum.coerceAtMost(min)

            max = (max + nums[i]).coerceAtLeast(nums[i])
            maxSum = maxSum.coerceAtLeast(max)

            total += nums[i]
        }
        val answer = maxSum.coerceAtLeast(total - minSum)
        return if (maxSum > 0) return answer
        else tempMax
    }
}

fun main() {
    val result1 = MaximumSumCircularSubarray.maxSubarraySumCircular(intArrayOf(1, -2, 3, -2))
    println(result1)

    val result2 = MaximumSumCircularSubarray.maxSubarraySumCircular(intArrayOf(5, -3, 5))
    println(result2)

    val result3 = MaximumSumCircularSubarray.maxSubarraySumCircular(intArrayOf(-3, -2, -3))
    println(result3)

    val result4 = MaximumSumCircularSubarray.maxSubarraySumCircular(intArrayOf(3, -1, 2, -1))
    println(result4)
}