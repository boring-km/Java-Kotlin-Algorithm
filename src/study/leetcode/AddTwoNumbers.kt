package study.leetcode

// https://leetcode.com/problems/add-two-numbers/
object AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var left = l1
        var right = l2

        var a = 0
        var b = 0

        val arr = IntArray(101)

        while (left?.`val` != null) {
            val data = left.`val`
            arr[a] = data
            a++
            left = left.next
        }
        while (right?.`val` != null) {
            val data = right.`val`
            if (arr[b] + data >= 10) {
                arr[b] = arr[b] + data - 10
                arr[b+1] += 1
            } else {
               arr[b] += data
            }
            b++
            right = right.next
        }

        for (i in 0..100) {
            if (arr[i] >= 10) {
                arr[i] -= 10
                arr[i+1] += 1
            }
        }

        val result = ListNode(arr[0])

        val list = arrayListOf<Int>()
        val maximum = Math.max(a, b)
        for (i in 1 .. maximum) {
            val item = arr[i]
            if (maximum == i && item == 0) {
                break
            }
            list.add(item)
        }

        if (arr.size > 1) {
            recursive(result, list, 0)
        }

        return result
    }

    private fun recursive(original: ListNode?, list: List<Int>, cur: Int) {
        if (cur == list.size) {
            return
        } else {
            original?.next = ListNode(list[cur])
            recursive(original?.next, list, cur + 1)
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val first = ListNode(9)
    first.next = ListNode(9)
    first.next?.next = ListNode(9)
    first.next?.next?.next = ListNode(9)
    first.next?.next?.next?.next = ListNode(9)
    first.next?.next?.next?.next?.next = ListNode(9)
    first.next?.next?.next?.next?.next?.next = ListNode(9)

    val second = ListNode(9)
    second.next = ListNode(9)
    second.next?.next = ListNode(9)
    second.next?.next?.next = ListNode(9)
    var result = AddTwoNumbers.addTwoNumbers(first, second)

    while (result?.`val` != null) {
        println(result.`val`)
        result = result.next
    }
}