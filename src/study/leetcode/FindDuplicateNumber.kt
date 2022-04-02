package study.leetcode

// https://leetcode.com/problems/find-the-duplicate-number
object FindDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
            if (map[num]!! > 1) {
                return num
            }
        }
        return 0
    }
}

fun main() {
    val result = FindDuplicateNumber.findDuplicate(intArrayOf(1, 3, 4, 2, 2))
    print(result)
}