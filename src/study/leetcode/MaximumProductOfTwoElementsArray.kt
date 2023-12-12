package study.leetcode

object MaximumProductOfTwoElementsArray {
    fun maxProduct(nums: IntArray): Int {
        val sorted = nums.sortedDescending()
        return (sorted[0] - 1) * (sorted[1] - 1)
    }
}