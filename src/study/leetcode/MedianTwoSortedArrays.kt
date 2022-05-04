package study.leetcode

object MedianTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        if (m > n) return findMedianSortedArrays(nums2, nums1)  // 길이 무조건 긴 array가 뒤로 가게 조절

        var low = 0
        var high = m

        while (low <= high) {
            val pX = (low + high) / 2
            val pY = (m + n + 1) / 2 - pX

            val maxLeftX = (if (pX == 0) Int.MIN_VALUE else nums1[pX - 1]).toDouble()
            val minRightX = (if (pX == m) Int.MAX_VALUE else nums1[pX]).toDouble()

            val maxLeftY = (if (pY == 0) Int.MIN_VALUE else nums2[pY - 1]).toDouble()
            val minRightY = (if (pY == n) Int.MAX_VALUE else nums2[pY]).toDouble()

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                return if ((m + n) % 2 != 0) Math.max(maxLeftX, maxLeftY) else ((Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2)
            } else if (maxLeftX > minRightY) {
                high = pX - 1
            } else {
                low = pX + 1
            }
        }
        return 0.0
    }
}

fun main() {
    val result = MedianTwoSortedArrays.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 7))
    println(result)
}
