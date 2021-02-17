package study.baekjoon

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var array: Array<LongArray>? = null
    var count = 0
    try {
        var number = Integer.parseInt(br.readLine())
        array = Array(number){LongArray(2)}
        for (i in 0..number-1) {
            var input = br.readLine().split(" ")
            array[i][0] = input[0].toLong()
            array[i][1] = input[1].toLong()
        }
        Arrays.sort(array, object: Comparator<LongArray> {
            override fun compare(p0: LongArray?, p1: LongArray?): Int {
                val a = p0!![1]
                val b = p1!![1]
                if (a == b) {
                    if (p0[0] < p1[0])
                        return -1
                    else
                        return 0
                } else if (a > b) {
                    return 1
                } else {
                    return -1
                }
            }
        })
        var last:Long = 0
        for (item in array) {
            if (last <= item[0] ) {
                last = item[1]
                count++
            }
        }
        print(count)
    } catch (e: IOException){}
}