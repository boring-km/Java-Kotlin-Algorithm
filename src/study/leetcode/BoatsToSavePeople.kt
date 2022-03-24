package study.leetcode

import java.util.*

// https://leetcode.com/problems/boats-to-save-people/
object BoatsToSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var result = 0

        val sorted = people.sortedDescending()
        val remainStack = Stack<Int>()

        // 내림차순 배열에서 큰 수부터 제거

        for (i in people.indices) {
            // 남아 있는 공간 중에 들어갈 수 있는 가장 큰 녀석이 들어온다면?
            if (remainStack.isNotEmpty() && remainStack.peek() >= sorted[i]) {
                remainStack.pop()   // 남아있는 공간이 채워졌다. 배를 보내자
            } else {
                val remain = limit - sorted[i]  // 배에 공간이 남아있다면,
                if (remain > 0) {
                    remainStack.push(remain)  // stack 추가
                }
                result++
            }
        }

        return result
    }
}

fun main() {
    val result = BoatsToSavePeople.numRescueBoats(
        intArrayOf(
            2,
            49,
            10,
            7,
            11,
            41,
            47,
            2,
            22,
            6,
            13,
            12,
            33,
            18,
            10,
            26,
            2,
            6,
            50,
            10
        ), 50
    )
    println(result)
}