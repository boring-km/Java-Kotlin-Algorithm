package study.leetcode

// https://leetcode.com/problems/max-number-of-k-sum-pairs/
object MaxNumberKSumPairs {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var result = 0
        val map = HashMap<Int, Int>()
        for (num in nums) {
            if (num < k) {
                var saved = map.getOrDefault(num, 0)
                if (saved == 0) {
                    map[k - num] = map.getOrDefault(k - num, 0) + 1
                } else {
                    map[num] = saved - 1
                    ++result
                }
            }
        }
        return result
    }
}
