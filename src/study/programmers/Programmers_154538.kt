package study.programmers

object Programmers_154538 {
    fun solution(x: Int, y: Int, n: Int): Int {
        val array = IntArray(y+1) { Int.MAX_VALUE }
        array[x] = 0

        for (i in x .. y) {
            if (array[i] == Int.MAX_VALUE) continue
            if (i + n <= y) {
                array[i+n] = Math.min(array[i + n], array[i] + 1)
            }
            if (i*2 <= y) {
                array[i*2] = Math.min(array[i*2], array[i] + 1)
            }
            if (i*3 <= y) {
                array[i*3] = Math.min(array[i*3], array[i] + 1)
            }
        }
        if(array[y]==Int.MAX_VALUE) return -1
        return array[y]
    }
}