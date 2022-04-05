package study.leetcode

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
object TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        var l = 0
        var r = numbers.size-1

        while (r - l > 0) {
            val sum = numbers[r] + numbers[l]
            if (sum == target) {
                return intArrayOf(l+1, r+1)
            } else if (sum > target) {
                r--
            } else {
                l++
            }
        }

        return numbers
    }
}

fun main() {
    val result = TwoSum2.twoSum(intArrayOf(-1, 0), -1)
    result.forEach { print("$it ") }
}