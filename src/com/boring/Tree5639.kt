package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val MAX = 10001
private val preorder = Array(MAX){IntArray(2)}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack = Stack<Int>()
    var num = -1
    var root = 0
    var last_v = 0
    while (true) {
        val t = br.readLine()
        if (t == null) {
            break
        }
        num = toint(t)
        if (stack.empty()) {
            stack.push(num)
            root = num
        } else {
            var temp_num = stack.pop()
            if (num < temp_num) {
                stack.push(temp_num) // 다시 넣기
                stack.push(num)
                preorder[temp_num][0] = num
                //preorder[]
            } else {
                stack.push(temp_num) // 잠깐 다시 넣기
                while (!stack.empty()) {
                    temp_num = stack.pop()
                    if (num > temp_num) {
                        last_v = temp_num
                        if (temp_num == root) {
                            stack.push(root)
                            stack.push(num)
                            preorder[root][1] = num
                        }
                    } else {
                        stack.push(temp_num)
                        preorder[last_v][1] = num
                        break
                    }
                }
            }
        }
    }
    postorder(preorder, root)
}
// 후위 순회
// left, right, root
private fun postorder(array: Array<IntArray>, value: Int) {
    if (value == -1) {
        return
    }
    // 재귀
    postorder(array, array[value][0])
    postorder(array, array[value][1])
    println(value)
}
private fun toint(s: String) : Int {
    return Integer.parseInt(s)
}