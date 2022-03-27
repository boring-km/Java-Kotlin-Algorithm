package study.leetcode

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
object WeakestRowInMatrix {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val result = IntArray(k)
        var cur = 0
        val n = mat.size

        val map: HashMap<Int, ArrayList<Int>> = HashMap<Int, ArrayList<Int>>()

        for (i in 0 until n) {
            val sum = mat[i].sum()
            val saved: ArrayList<Int> = map.getOrDefault(sum, arrayListOf())
            saved.add(i)
            map[sum] = saved
        }

        for (item in map.keys.sorted()) {
            map[item]?.forEach { num ->
                run {
                    if (cur == k) return result
                    result[cur] = num
                    ++cur
                }
            }
        }

        return result
    }
}

fun main() {
    val result = WeakestRowInMatrix.kWeakestRows(
        arrayOf(
            intArrayOf(1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
            intArrayOf(1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0),
            intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0),
            intArrayOf(1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        ),
        1
    )
    result.forEach { n -> print("$n ") }
}

/*
[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0],
[1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0],
[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0],
[1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0],
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0],
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0],
[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
1
 */