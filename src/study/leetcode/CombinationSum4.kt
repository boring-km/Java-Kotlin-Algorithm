package study.leetcode

private object CombinationSum4 {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target+1)
        dp[0] = 1

        for (i in 1 .. target) {
            nums.forEach {
                // 핵심 dp 알고리즘 부분 (num으로 만들 수 있는 숫자를 1부터 target까지 저장하면서 구하기)
                val diff = i - it
                if (diff >= 0) {
                    dp[i] += dp[diff]
                }
            }
        }
        return dp[target]
    }
}

fun main() {
    val result = CombinationSum4.combinationSum4(intArrayOf(2, 3), 35)
    println(result)
}