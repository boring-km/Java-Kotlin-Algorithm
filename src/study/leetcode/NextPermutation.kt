package study.leetcode


object NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {

        val sortedArray = nums.sorted()

        val list = ArrayList<Int>()
        for (n in sortedArray) list.add(n)

        val resultList = permutation(list).distinct()

        for (i in resultList.indices) {
            var isEqual = true
            for (j in resultList[i].indices) {
                if (nums[j] != resultList[i][j]) {
                    isEqual = false
                    break
                }
            }
            if (isEqual) {
                if (i == resultList.size - 1) {
                    resultList[0].toIntArray().copyInto(nums)
                    break
                } else {
                    resultList[i + 1].toIntArray().copyInto(nums)
                    break
                }
            }
        }
    }
}

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}

fun main() {
    val arr = intArrayOf(1, 5, 1)
    val result = NextPermutation.nextPermutation(arr)
    arr.forEach { print("$it ") }
}