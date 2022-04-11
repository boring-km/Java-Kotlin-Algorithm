package study.leetcode

import java.util.*
import kotlin.collections.ArrayList

// https://leetcode.com/problems/shift-2d-grid/
object Shift2DGrid {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val q: Deque<Int> = LinkedList<Int>()

        val n = grid.size
        val m = grid[0].size

        for (i in 0 until n) {
            for (j in 0 until m) {
                q.add(grid[i][j])
            }
        }
        for (i in 0 until k) {
            val last = q.pollLast()
            q.addFirst(last)
        }
        val result = arrayListOf<ArrayList<Int>>()
        for (i in 0 until n) {
            result.add(arrayListOf())
            for (j in 0 until m) {
                result[i].add(q.pollFirst())
            }
        }
        return result
    }
}

fun main() {
    val result = Shift2DGrid.shiftGrid(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)), 1)
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            print("${result[i][j]} ")
        }
        println()
    }
}