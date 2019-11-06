package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader

private var array:Array<ArrayList<Int>>? = null
private var v = 0
private var visited:BooleanArray? = null
private var parent: IntArray? = null
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
        // 두 정점이 각각 연결됨 (그래프)
        array!![first].add(second)
        array!![second].add(first)
    }
    // 루트 1 방문
    visited!![1] = true
    // 1부터 dfs 탐색
    dfs(1)
    // 결과 출력
    for (i in 2..v) {
        println(parent!![i])
    }
}
// dfs로 풀기
private fun dfs(node: Int) {
    // child는 해당 인덱스(노드)와 연결되어있는 ArrayList<Int>(노드 집합)
    //
    val child = array!![node]
    // 리스트에 담겨진 만큼(점이 연결된 갯수 만큼)
    for (c in child) {// c는 연결되어있는 점(노드)
        if (!visited!![c]) {// 방문한 노드가 아니면?
            parent!![c] = node // 방문하지 않은 이 노드의 부모노드를 현재 노드로 설정
            visited!![c] = true // 방문~
            dfs(c) // 재귀
        }
    }
}