package study.leetcode.dp

import java.util.*


object BestTeamWithNoConflicts {

    internal class Player(var age: Int, var score: Int)

    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {

        val n = scores.size

        val players = Array(n) { i -> Player(ages[i], scores[i]) }

        Arrays.sort(players) { a, b ->
            // age가 같으면 score가 큰 값으로 정렬
            if (a.age == b.age) {
                b.score - a.score
            } else { // 다르면 age가 더 큰 값으로 정렬 (내림차순)
                b.age - a.age
            }
        }

        val dp = IntArray(n)

        for (i in 0 until n) {
            val playerScore = players[i].score
            dp[i] = playerScore

            // 나이가 적은 player와는 비교하지 않음
            for (j in 0 until i) {
                val olderOrSamePlayerScore = players[j].score
                // 더 나이가 많거나 같은 플레이어의 스코어가 같거나 더 높다면? -> 작으면 나이가 어린데 점수가 많아서 충돌
                if (olderOrSamePlayerScore >= playerScore) {
                    // 더 나이 많은 플레이어의 점수들을 현재 플레이어의 스코어를 더했을 때 최댓값이 더 높아지면 계속 plus
                    dp[i] = dp[i].coerceAtLeast(dp[j] + playerScore)
                }
            }
        }

        return dp.max()
    }
}

fun main() {
    val result = BestTeamWithNoConflicts.bestTeamScore(intArrayOf(1, 3, 5, 10, 15), intArrayOf(1, 2, 3, 4, 5))
    println(result)
}