package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val v = Integer.parseInt(br.readLine())
    // 2차 배열은 인덱스가 10만이 되어버리면
    // 시간 제한에서 1초를 넘어버린다
    val array = Array(v + 1) { IntArray(v + 1) }
    for (i in 0..v - 2) {
        val temp = br.readLine().split(" ")
        val first = Integer.parseInt(temp[0])
        val second = Integer.parseInt(temp[1])
        array[first][second] = 1
        array[second][first] = 1
    }
    val visited = BooleanArray(v + 1)
    val parent = IntArray(v + 1)
    val queue = LinkedList<Int>()
    var item: Int
    var count = 0
    var tempid = 0
    queue.add(1)

    while (queue.size != 0) {
        item = queue.poll()
        //if (!visited[item]) {
        for (i in 1..v) {
            if (array[item][i] == 1) {
                ++count
                if (item == 1) {
                    parent[i] = item
                }
                visited[item] = true
                if (!visited[i]) {
                    queue.add(i)
                }
                tempid = i
                if (parent[i] != 0) {
                    parent[item] = i
                }
            }
        }
        if (count == 1) {
            parent[item] = tempid
        }
        tempid = 0
        count = 0
    }
    //}
    for (i in 2..v) {
        println(parent[i])
    }
}