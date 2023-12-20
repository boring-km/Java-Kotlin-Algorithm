package study.leetcode

object BuyTwoChocolates {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val sorted = prices.sorted()
        val sum = sorted[0] + sorted[1]
        return if (sum <= money) {
            money - sum
        } else {
            money
        }
    }
}