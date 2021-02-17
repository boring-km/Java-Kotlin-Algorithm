package study.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine()
    var input = br.readLine().split(" ")
    var result:IntArray = IntArray(input.size)
    for (i in 0..input.size-1) {
        result[i] = Integer.parseInt(input[i])
    }
    Arrays.sort(result)
    var result_value = 0
    for (i in 0..result.size-1) {
        result_value += result[i]*(result.size - i)
    }
    print(result_value)

}