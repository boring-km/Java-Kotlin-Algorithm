package study.leetcode

// 문제: https://leetcode.com/problems/next-permutation/
// 풀이: https://engkimbs.tistory.com/674
object NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        var a = nums.size - 2

        while (a >= 0 && nums[a] >= nums[a+1]) {    // 뒤에 있는 숫자가 더 클 때까지 반복
            a--
        }

        if (a < 0) nums.reverse()   // 마지막 숫자가 더 컸다면 뒤집으면 된다.
        else {
            var b = a+1 // 발견한 숫자 다음부터 다시 숫자가 더 큰 수를 발견할 때까지
            while (b < nums.size && (nums[b] - nums[a]) > 0) {
                b++
            }
            swap(nums, a, b-1)  // 서로 위치 바꾸기
            val copyOfRange = nums.copyOfRange(a + 1, nums.size)
            val reversed = copyOfRange.reversed()
            for (i in reversed.indices) {
                nums[i+a+1] = reversed[i]
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val arr = intArrayOf(1, 3, 2)
    val result = NextPermutation.nextPermutation(arr)
    arr.forEach { print("$it ") }
}