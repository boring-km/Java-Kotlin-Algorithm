package study.leetcode

object RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        val set = HashSet(nums.toList()).toList().sorted()
        println(set)

        return set.size
    }

    fun anotherSolution(nums: IntArray): Int {
        var j = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i-1]) {
                nums[j++] = nums[i]
            }
        }
        return j
    }
}

fun main() {
    println(RemoveDuplicatesFromSortedArray.removeDuplicates(intArrayOf(1,1,2)))
}