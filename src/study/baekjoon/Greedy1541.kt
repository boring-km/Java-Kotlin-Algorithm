package study.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val data = br.readLine()+"-"
    val arr = data.toCharArray()

    var temp: Char
    var num = ""
    var cur = ""
    var par = -1
    val addlist:ArrayList<Int> = ArrayList()
    for (element in arr) {
        temp = element
        if (!(temp == '+' || temp == '-')) {
            num += temp
        } else {
            if (temp == '+') {
                if (par == -1) {
                    par = Integer.parseInt(num)
                }
                addlist.add(Integer.parseInt(num))
                num = ""
            } else if (temp == '-') {

                addlist.add(Integer.parseInt(num))
                par = addlist.sum()
                cur += "$par-"
                addlist.clear()
                num = ""

            }
        }
    }
    cur = cur.substring(0, cur.length-1)
    val list = cur.split("-")
    var result = Integer.parseInt(list[0])
    for (i in 1 until list.size){
        result -= Integer.parseInt(list[i])
    }
    print(result)
}