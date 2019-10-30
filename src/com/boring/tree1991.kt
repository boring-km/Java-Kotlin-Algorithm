package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = Integer.parseInt(br.readLine());
    // 알파벳 26자랑 left, right
    val array = Array(26){IntArray(2)}
    for (i in 0..number-1) {

        val input = br.readLine().split(" ")

        // A B C D E F G H I ~
        // 0 1 2 3 4 5 6 7 8 ~

        val value = input[0].get(0) - 'A' // 정수
        val left = input[1].get(0)
        val right = input[2].get(0)
        if (left == '.') {
            array[value][0] = -1 // 정수
        } else {
            array[value][0] = left - 'A' // 정수
        }
        if (right == '.') {
            array[value][1] = -1 // 정수
        } else {
            array[value][1] = right - 'A' // 정수
        }
    }
    // 0은 그냥 초기값
    // 어차피 A부터 시작함
    preorder(array, 0)
    println()
    inorder(array, 0)
    println()
    postorder(array, 0)
    println()
}
// 전위 순회
// root, left, right
private fun preorder(array: Array<IntArray>, value: Int) {
    if (value == -1) {
        return
    }
    print((value + 'A'.toInt()).toChar())
    // 재귀
    preorder(array, array[value][0])
    preorder(array, array[value][1])
}
// 중위 순회
// left, root, right
private fun inorder(array: Array<IntArray>, value: Int) {
    if (value == -1) {
        return
    }
    // 재귀
    inorder(array, array[value][0])
    print((value + 'A'.toInt()).toChar())
    inorder(array, array[value][1])
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
    print((value + 'A'.toInt()).toChar())
}