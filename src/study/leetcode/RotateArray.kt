package study.leetcode

import java.util.*

// https://leetcode.com/problems/rotate-array/
object RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        val queue: Deque<Int> = LinkedList()
        nums.forEach { queue.add(it) }

        for (i in 0 until k) {
            queue.addFirst(queue.pollLast())
        }

        for (i in nums.indices) {
            nums[i] = queue.pollFirst()
        }
    }
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    RotateArray.rotate(arr, 3)
    arr.forEach { print("$it ") }
}