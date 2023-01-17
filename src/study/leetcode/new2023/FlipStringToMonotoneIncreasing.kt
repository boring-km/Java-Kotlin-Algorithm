package study.leetcode.new2023

object FlipStringToMonotoneIncreasing {
    fun minFlipsMonoIncr(s: String): Int {

        val zeros = IntArray(20001)

        if (s[0] == '0') {
            zeros[0] = 1
        } else {
            zeros[0] = 0
        }
        // 왼쪽에서 1부터 오른쪽으로
        for (i in 1 until s.length) {
            if (s[i] == '1') {
                zeros[i] = zeros[i - 1]
            } else {
                // 이전 데이터 활용 -> DP
                zeros[i] = zeros[i - 1] + 1
            }
        }
        // 전부 1인 문자열이 되도록 할 때 flip 수
        var result = zeros[s.length - 1]
        for (i in s.indices) {
            val left = i + 1 - zeros[i]  // 현재 인덱스 위치에서 0의 갯수 빼기 -> 1 구하기
            val right = zeros[s.length - 1] - zeros[i] // 현재 위치에서 마지막까지 추가된 0 구하기
            // 왼쪽 1의 갯수 + 오른쪽 0의 갯수
            result = result.coerceAtMost(left + right)
        }

        return result
    }
}