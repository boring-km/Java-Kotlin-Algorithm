import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    // 키보드 입력 빨리 받기 with StringTokenizer
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    // 누적합 배열 생성
    val prefixSum = IntArray(n + 1)
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
    }

    // 최대값 초기화
    var max = Int.MIN_VALUE
    
    // k만큼 이동하면서 최대값 찾기
    for (i in 0..n - k) {
        val sum = prefixSum[i + k] - prefixSum[i]
        max = max.coerceAtLeast(sum)
    }

    // 결과 출력
    println(max)
}