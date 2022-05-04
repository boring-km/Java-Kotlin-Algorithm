package study.leetcode

object MedianTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val len = m + n
        return if (len % 2 == 0) {
            val left = findKthHelper(nums1, 0, nums2, 0, len / 2).toDouble()
            val right = findKthHelper(nums1, 0, nums2, 0, len / 2 + 1).toDouble()
            (left + right) / 2
        } else {
            findKthHelper(nums1, 0, nums2, 0, len / 2 + 1).toDouble()
        }
    }

    private fun findKthHelper(arrA: IntArray, a: Int, arrB: IntArray, b: Int, k: Int): Int {
        if (a >= arrA.size) {
            return arrB[b + k - 1]
        }
        if (b >= arrB.size) {
            return arrA[a + k - 1]
        }
        if (k == 1) {
            return Math.min(arrA[a], arrB[b])
        }
        // 이진 탐색을 한다.
        val aMid = a + (k / 2) - 1
        val bMid = b + (k / 2) - 1
        val aVal = if (aMid >= arrA.size) Int.MAX_VALUE else arrA[aMid]
        val bVal = if (bMid >= arrB.size) Int.MAX_VALUE else arrB[bMid]
        return if (aVal <= bVal) {
            findKthHelper(arrA, aMid + 1, arrB, b, k - k / 2)
        } else {
            findKthHelper(arrA, a, arrB, bMid + 1, k - k / 2)
        }
    }
}

fun main() {
    val result = MedianTwoSortedArrays.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 7))
    println(result)
}
