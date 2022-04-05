package study.leetcode

// https://leetcode.com/problems/binary-search/
object BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (end - start >= 0) {
            val mid = (start + end) / 2
            if (target < nums[mid]) {
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}

fun main() {
    val target = -1
    val arr = intArrayOf(1,2,3,4,5)
    val result = BinarySearch.search(arr, target)
    println(result)
}