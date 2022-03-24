package study.leetcode

// https://leetcode.com/problems/two-sum/
object TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (i == j) continue
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return nums
    }
}

fun main() {
    val result: IntArray = TwoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)
    result.forEach { num -> println(num) }
}