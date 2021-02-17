package study.baekjoon

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.System.`in`
import java.lang.System.arraycopy
import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    //println("Kotlin")
    val array = Array(1002) { IntArray(1002) }
    //var arr =
    var br = BufferedReader(InputStreamReader(`in`))
    try {
        var input = br.readLine().split(" ")
        var h = Integer.parseInt(input[0])
        var w = Integer.parseInt(input[1])

        for (i in 0..h - 1) {
            var tmp = br.readLine().split("")

            for (j in 1..tmp.size - 2) {
                array[i][j - 1] = Integer.parseInt(tmp[j])
            }
        }
        println(bfs(array, 0, 0, h, w))/*
        for (i in 0..h-1) {
            for (j in 0..w) {
                print(array[i][j])
            }
            println("")
        }*/

    } catch (e: IOException) {
    }
}

fun bfs(array: Array<IntArray>, x: Int, y: Int, h: Int, w: Int): Int {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val qx: Queue<Int> = LinkedList<Int>()
    val qy: Queue<Int> = LinkedList<Int>()
    val visit = Array(1002) { BooleanArray(1002) }
    qx.add(x)
    qy.add(y)
    var kx = 0
    var ky = 0
    var tkx = 0
    var tky = 0
    var count = 0
    var count_two = 0
    var tmp_qx = LinkedList<Int>()
    var tmp_qy = LinkedList<Int>()
    var tmp_visit = Array(1002) { BooleanArray(1002) }
    var tmp_array = Array(1002) { IntArray(1002) }
    for (k in 0..3) {
        while (!qx.isEmpty() && !qy.isEmpty()) {

            kx = qx.poll()
            ky = qy.poll()
            for (i in 0..3) {
                var tx = kx + dx[i]
                var ty = ky + dy[i]

                if (tx >= 0 && ty >= 0 && tx < h && ty < w) {
                    if (array[tx][ty] == 0 && !visit[tx][ty]) {
                        qx.add(tx)
                        qy.add(ty)
                        visit[tx][ty] = true
                        println("visit: $kx $ky")
                        array[tx][ty] = array[kx][ky] + 1
                    }
                }
            }
        }
        println("k: $k; last: $kx $ky")
        if (kx != h-1 && ky != w-1) {

            if (count == 0) {
                tmp_qx.addAll(qx)
                tmp_qy.addAll(qy)
                for (m in 0..1001) {
                    for (j in 0..1001) {
                        tmp_array[m][j] = array[m][j]
                        tmp_visit[m][j] = visit[m][j]
                    }
                }
                //System.arr
                tkx = kx
                tky = ky
                var tx = kx + dx[k]
                var ty = ky + dy[k]
                if (tx >= 0 && ty >= 0 && tx < h && ty < w) {

                    qx.add(tx)
                    qy.add(ty)
                    visit[tx][ty] = true
                    println("addvisit: $tx $ty")
                    array[tx][ty] = array[kx][ky] + 1
                }
                ++count;
            } else {
                qx.clear()
                qx.addAll(tmp_qx)
                qy.clear()
                qy.addAll(tmp_qy)
                kx = tkx
                ky = tky
                for (m in 0..1001) {
                    for (j in 0..1001) {
                        array[m][j] = tmp_array[m][j]
                        visit[m][j] = tmp_visit[m][j]
                    }
                }
                var tx = kx + dx[k]
                var ty = ky + dy[k]
                if (tx >= 0 && ty >= 0 && tx < h && ty < w) {

                    qx.add(tx)
                    qy.add(ty)
                    visit[tx][ty] = true
                    println("addothervisit: $tx $ty")
                    array[tx][ty] = array[kx][ky] + 1
                }
                ++count;
            }
        } else {
            break
        }
    }
    if (kx != h-1 && ky != w-1)
        return -1
    else
        return array[h - 1][w - 1] + 1
}