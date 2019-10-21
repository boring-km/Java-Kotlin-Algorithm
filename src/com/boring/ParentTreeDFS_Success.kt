package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader

var array:Array<ArrayList<Int>>? = null
var v = 0
var visited:BooleanArray? = null
var parent: IntArray? = null
/*
    질문 참고: https://www.acmicpc.net/board/view/41682
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    v = Integer.parseInt(br.readLine())
    visited = BooleanArray(v + 1)
    // 2차 배열 대신 정수리스트 배열을 생성
    // Java에서는 ArrayList<Integer>[]로 표현할 듯??
    array = Array(v + 1) { ArrayList<Int>() }
    parent = IntArray(v + 1)
    for (i in 0..v - 2) {
        val temp = br.readLine().split(" ")
        val first = Integer.parseInt(temp[0])
        val second = Integer.parseInt(temp[1])
        // add를 이용해 추가하는 방식
        array!![first].add(second)// = IntArray(1){second}
        array!![second].add(first)// = IntArray(1){first}
    }
    visited!![1] = true

    dfs(1)

    for (i in 2..v) {
        println(parent!![i])
    }
}
// dfs로 풀기
fun dfs(node: Int) {
    // child는 해당 인덱스에 있는 ArrayList<Int>
    val child = array!![node]
    // 리스트에 담겨진 만큼
    for (c in child) {
        if (!visited!![c]) {
            parent!![c] = node
            visited!![c] = true
            dfs(c)
        }
    }
}