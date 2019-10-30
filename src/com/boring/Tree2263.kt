package com.boring

import java.io.BufferedReader
import java.io.InputStreamReader

// 참고..
// https://jaimemin.tistory.com/1156

private const val MAX = 100000 + 1

var inorder = IntArray(MAX)
var postorder = IntArray(MAX)
var idx = IntArray(MAX)

fun preorder(in_start: Int, in_end: Int, post_start: Int, post_end: Int) {
    if (in_start > in_end || post_start > post_end) {
        return
    }
    val root = postorder[post_end]
    print("$root ")
    // Left
    preorder(in_start, idx[root]-1, post_start, post_start + (idx[root] - in_start)-1)
    // Right
    preorder(idx[root] + 1, in_end, post_start + (idx[root] - in_start), post_end - 1)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = Integer.parseInt(br.readLine())

    val first = br.readLine().split(" ")
    for (i in 0 until number) {
        inorder[i] = toint(first[i])
    }
    val second = br.readLine().split(" ")
    for (i in 0 until number) {
        postorder[i] = toint(second[i])
    }
    for (i in 0 until number) {
        idx[inorder[i]] = i
    }
    preorder(0, number-1, 0, number-1)
}
private fun toint(s: String) : Int {
    return Integer.parseInt(s)
}