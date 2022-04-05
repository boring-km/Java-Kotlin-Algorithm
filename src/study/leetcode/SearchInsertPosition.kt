package study.leetcode

// https://leetcode.com/problems/search-insert-position/
object SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var mid = 0

        if (target < nums[start]) return 0
        if (nums[end] < target) return end+1

        while (end - start >= 0) {
            mid = (start + end) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                start = mid + 1
                if (end - start < 0) return mid+1
            } else {
                end = mid - 1
                if (end - start < 0) return mid
            }
        }
        return mid+1
    }
}

fun main() {
    val result = SearchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 9)
    println(result)
}