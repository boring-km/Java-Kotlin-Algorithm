import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val prefix = IntArray(n + 1) { 0 }

    for (i in 0 until n) {
        prefix[i+1] = Math.max(prefix[i] + arr[i], arr[i])
    }

    // prefix 2번 인덱스부터 n번 인덱스까지 중 최대값 찾기
    println(prefix.slice(1..n).maxOrNull())
}