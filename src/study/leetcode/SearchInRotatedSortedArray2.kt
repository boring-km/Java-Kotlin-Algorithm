package study.leetcode

object SearchInRotatedSortedArray2 {
    fun search(nums: IntArray, target: Int): Boolean {
        val res = nums.find { num -> num == target }
        if (res == target) return true
        return false
    }
}

fun main() {
    val result = SearchInRotatedSortedArray2.search(intArrayOf(3), 3)
    println(result)
}