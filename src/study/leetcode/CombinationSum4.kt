package study.leetcode

private object CombinationSum4 {

    private var answer = 0

    fun combinationSum4(nums: IntArray, target: Int): Int {
        dfs(nums.sortedArray(), 0, target)
        return answer
    }

    fun dfs(nums: IntArray, cur: Int, target: Int) {

        for (i in nums.indices) {
            if (nums[i] + cur < target) {
                // dfs
                dfs(nums, nums[i] + cur, target)
            } else if (nums[i] + cur == target) {
                answer++
                return
            } else {
                return
            }
        }
    }
}

fun main() {
    val result = CombinationSum4.combinationSum4(intArrayOf(2, 1, 3), 10)
    println(result)
}