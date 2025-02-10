package study.baekjoon.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (mp, mf, ms, mv) = br.readLine().split(" ").map { it.toInt() }
    val ingredients = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    br.close()

    var minCost = Int.MAX_VALUE
    var bestCombination: List<Int> = emptyList()

    fun dfs(index: Int, selected: List<Int>, p: Int, f: Int, s: Int, v: Int, cost: Int) {
        if (index == n) {
            if (p >= mp && f >= mf && s >= ms && v >= mv) {
                if (cost < minCost || (cost == minCost && selected.joinToString("") < bestCombination.joinToString(""))) {
                    minCost = cost
                    bestCombination = selected
                }
            }
            return
        }

        val (tp, tf, ts, tv, tc) = ingredients[index]

        // 현재 재료를 선택하는 경우
        dfs(index + 1, selected + (index + 1), p + tp, f + tf, s + ts, v + tv, cost + tc)
        // 현재 재료를 선택하지 않는 경우
        dfs(index + 1, selected, p, f, s, v, cost)
    }

    dfs(0, emptyList(), 0, 0, 0, 0, 0)

    if (minCost == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(minCost)
        println(bestCombination.joinToString(" "))
    }
}
