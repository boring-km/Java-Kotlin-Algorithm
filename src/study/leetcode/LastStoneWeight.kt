package study.leetcode

// https://leetcode.com/problems/last-stone-weight/
object LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        stones.sort()
        val stoneList: MutableList<Int> = stones.toMutableList()

        while (stoneList.size > 2) {
            val first = stoneList.removeAt(stoneList.size - 1)
            val second = stoneList.removeAt(stoneList.size - 1)
            stoneList.add(first - second)
            stoneList.sort()
        }

        if (stoneList.size == 2) {
            return Math.abs(stoneList[1] - stoneList[0])
        } else if (stoneList.size == 1) {
            return stoneList[0]
        } else {
            return 0
        }
    }
}

fun main() {
    println(LastStoneWeight.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}