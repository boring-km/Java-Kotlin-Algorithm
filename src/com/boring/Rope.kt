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
    var flag = false
    if (number == 1) {
        result = array[0]
    }
    for (i in 0..number-2) {
        if ((number-i)*array[i] < (number-(i+1))*array[i+1]) {
            result = (number-(i+1))*array[i+1]
            flag = true
        } else {
            if (!flag) {
                result = number*array[0]
            }
        }
    }
    print(result)
    //모든 로프를 전부 사용할 경우
    //print(number*array[0])
}