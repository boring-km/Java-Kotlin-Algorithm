package study.leetcode

object ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(2 * n)

        for (i in 0 until n) {
            result[i * 2] = nums[i]
        }
        for (i in n until 2 * n) {
            result[(i - n) * 2 + 1] = nums[i]
        }

        return result
    }
}

fun main() {
    val result = ShuffleTheArray.shuffle(intArrayOf(1,2,3,4,4,3,2,1), 4)
    result.forEach { print(it) }
}

// 0 1 2 3 4 5
// 0 2 4 1 3 5