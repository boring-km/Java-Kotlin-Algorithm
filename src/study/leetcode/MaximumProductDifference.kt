package study.leetcode

object MaximumProductDifference {
    fun maxProductDifference(nums: IntArray): Int {
        val sorted = nums.sorted()
        val n = sorted.size

        return (sorted[n-1] * sorted[n-2]) - (sorted[0] * sorted[1])
    }
}