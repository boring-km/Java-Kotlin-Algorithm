package study.leetcode

import java.util.Stack

object BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val list_a = Stack<Char>()
        val list_b = Stack<Char>()

        for (c in s.toCharArray()) {
            if (c == '#') {
                if (list_a.isNotEmpty()) {
                    list_a.pop()
                }
            } else {
                list_a.push(c)
            }
        }


        for (c in t.toCharArray()) {
            if (c == '#') {
                if (list_b.isNotEmpty()) {
                    list_b.pop()
                }
            } else {
                list_b.push(c)
            }
        }

        return String(list_a.toCharArray()) == String(list_b.toCharArray())
    }
}

fun main() {
    BackspaceStringCompare.backspaceCompare("ab#c", "ad#c")
}