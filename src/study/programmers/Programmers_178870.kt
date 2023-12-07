package study.programmers

object Programmers_178870 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = intArrayOf()

        var max = 0
        var end = 0

        var dist = sequence.size    // 최대 길이

        for (start in sequence.indices) {
            while (max < k && end < sequence.size) {
                max += sequence[end]
                end++
            }
            if (max == k && end - 1 - start < dist) {
                answer = intArrayOf(start, end - 1)
                dist = end - 1 - start  // 최소 길이 갱신
            }
            max -= sequence[start]
        }

        return answer
    }
}