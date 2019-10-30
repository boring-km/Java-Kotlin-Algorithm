package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader

private var input_amount = 0
private var array: Array<ArrayList<IntArray>> = emptyArray()
private var temp_res: IntArray? = null
private var visited:BooleanArray? = null

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    input_amount = toint(br.readLine())
    array = Array(input_amount + 1) { ArrayList<IntArray>() }
    visited = BooleanArray(input_amount + 1)
    temp_res = IntArray(input_amount + 1)

    var temp_fisrt = 0
    var temp_second = 0
    var cur_num = 0
    var count = 0
    for (i in 0 until input_amount) {
        val temp = br.readLine().split(" ")
        cur_num = toint(temp[0])
        for (j in 1..temp.size - 1) {
            if (toint(temp[j]) != -1) {
                if (j % 2 == 1) {
                    // 정점의 위치
                    ++count
                    temp_fisrt = toint(temp[j]) // cur_num과 연결되는 정점
                } else {
                    ++count
                    temp_second = toint(temp[j]) // 그 정점까지의 거리
                }
                if (count == 2) {
                    val temp_array = IntArray(2)
                    temp_array[0] = temp_fisrt // cur_num과 연결되는 정점
                    temp_array[1] = temp_second // 그 정점까지의 거리
                    array[cur_num].add(temp_array)
                    count = 0
                }
            }
        }
    }
    // 일단 cur_num에서 제일 먼 점을 찾기
    // 그 점에서 가장 먼 점을 찾으면 그 둘의 거리가 트리의 지름이다.
    // https://blog.myungwoo.kr/112
    // cur_num: 5
    val start = cur_num
    val len = 0
    dfs(start, array, len)
    var value = 0
    var max = 0
    for (i in temp_res!!.indices) {
        // System.out.println(temp_res!![i])
        if (max < temp_res!![i]) {
            max = temp_res!![i]
            value = i+1
        }
    }
    // temp_res 초기화
    temp_res = IntArray(input_amount + 1)
    visited = BooleanArray(input_amount + 1)
    // 재탐색
    dfs(value, array, len)
    // 내림차순 정렬
    temp_res!!.sortDescending()
    println(temp_res!![0])
}

private fun dfs(start: Int, array: Array<ArrayList<IntArray>>, length: Int) {
    for (item in array[start]) {
        visited!![start] = true
        if (!visited!![item[0]]) {
            temp_res!![start] = length + item[1]
            dfs(item[0], array, length + item[1])
        }
    }
}

private fun toint(num: String): Int {
    return Integer.parseInt(num)
}