package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = Integer.parseInt(br.readLine())
    var array = IntArray(number)
    for (i in 0..number-1) {
        array[i] = Integer.parseInt(br.readLine())
    }
    Arrays.sort(array)
    var result = 0
    var temp = 0
    for (i in 0..number-1) {
        temp = (number-i)*array[i]
        if (temp > result) {
            result = temp
        }
    }
    print(result)
}