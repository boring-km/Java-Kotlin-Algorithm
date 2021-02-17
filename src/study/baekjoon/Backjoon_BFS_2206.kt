package study.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private class Place(y: Int, x: Int, dis: Int, drill: Int) {
    var x: Int? = 0
    var y: Int? = 0
    var dis: Int? = 0
    var drill: Int? = 0

    init {
        this.y = y
        this.x = x
        this.dis = dis
        this.drill = drill
    }
}

private var N = 0
private var M = 0
private var ans = 0
private var map: Array<IntArray>? = null
private var visit: Array<IntArray>? = null

private var dy = intArrayOf(-1, 1, 0, 0)
private var dx = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var str = br.readLine().split(" ")
    N = toint(str[0])
    M = toint(str[1])

    map = Array(N) { IntArray(M) }
    visit = Array(N) { IntArray(M) }

    for (i in 0..N - 1) {

        str = br.readLine().split("")

        for (j in 1..M) {
            map!![i][j-1] = toint(str[j])
            visit!![i][j-1] = Integer.MAX_VALUE // 최대값
        }
    }

    ans = Integer.MAX_VALUE

    bfs(0,0)
    if (ans == Integer.MAX_VALUE) {
        println(-1)
    } else {
        println(ans)
    }
}

private fun bfs(y: Int, x: Int) {
    val q = LinkedList<Place>()
    // y좌표, x좌표, 이동거리, 공사횟수
    q.add(Place(y, x, 1, 0))
    visit!![y][x] = 0
    while (!q.isEmpty()) {
        val p = q.poll()
        if (p.y == N - 1 && p.x == M - 1) {
            ans = p.dis!!
            break
        }
        for (i in 0..3) {
            val ny = p.y!! + dy[i]
            val nx = p.x!! + dx[i]

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue
            }
            if (visit!![ny][nx] <= p.drill!!) {
                continue
            }
            if (map!![ny][nx] == 0) {
                visit!![ny][nx] = p.drill!!
                q.add(Place(ny, nx, p.dis!!+1, p.drill!!))
            } else {
                if (p.drill == 0) {
                    visit!![ny][nx] = p.drill!! + 1
                    q.add(Place(ny, nx, p.dis!! +1, p.drill!! +1))
                }
            }
        }
    }
}

private fun toint(s: String): Int {
    return Integer.parseInt(s)
}