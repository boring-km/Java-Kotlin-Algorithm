package study.baekjoon.backtracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

object NandM3 {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    fun solution(n: Int, m: Int) {
        dfs(0, n, m, IntArray(m))
        bw.flush()
        bw.close()
    }

    fun dfs(cur: Int, n: Int, m: Int, arr: IntArray) {
        if (cur == m) {
            arr.forEach { bw.write("$it ")}
            bw.write("\n")
            return
        }

        for (i in 0 until n) {
            arr[cur] = i+1
            dfs(cur+1, n, m, arr)
        }
    }
}

fun main() {
    val (a, b: String) = readLine()!!.split(' ')
    NandM3.solution(a.toInt(), b.toInt())
}