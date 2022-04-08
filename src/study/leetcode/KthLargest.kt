package study.leetcode

import java.util.*

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest(var k: Int, nums: IntArray) {

    var pq = PriorityQueue<Int>()

    init {
        pq = PriorityQueue { a: Int, b: Int -> a - b }
        for (num in nums) pq.add(num)   // 내림차순으로 저장
        while (pq.size > k) pq.poll()   // k개 넘으면 제일 작은 수 out
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > k) pq.poll()  // k개 넘으면 제일 작은 수 out
        return pq.peek()
    }

}