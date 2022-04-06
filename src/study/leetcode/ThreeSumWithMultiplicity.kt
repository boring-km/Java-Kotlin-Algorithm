package study.leetcode

// https://leetcode.com/problems/3sum-with-multiplicity/
object ThreeSumWithMultiplicity {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val c = LongArray(101)
        for (a in arr) {
            c[a]++
        }
        var result = 0L

        for (i in 0..100)
            for (j in i..100) {
                val k = target - i - j  // 남은 수 (여기가 핵심)
                if (k > 100 || k < 0) continue  // 아직 남은 수가 적당하지 않으면 다음 j
                if (i == j && j == k)   // 셋다 같음
                    result += c[i] * (c[j] - 1) * (c[k] - 2) / 6    // 3개 다 같을 때 조합식
                else if (i == j)
                    result += c[i] * (c[j] - 1) / 2 * c[k]  // 2개만 같을 때
                else if (j < k)
                    result += c[i] * c[j] * c[k]    // 서로 다 다름
            }
        return (result % (1e9 + 7)).toInt()
    }
}

fun main() {
    println(ThreeSumWithMultiplicity.threeSumMulti(intArrayOf(1,1,2,2,3,3,4,4,5,5), 8))
}