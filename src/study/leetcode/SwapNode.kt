package study.leetcode

object SwapNode {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    var front = 0
    private var back = 0
    private var t = 0
    private val record = ArrayList<Int>()

    fun swapNodes(head: ListNode?, k: Int): ListNode? {

        t = k
        var copy = head

        while (copy?.`val` != null) {
            record.add(copy.`val`)
            copy = copy.next
        }
        front = record[k - 1]
        back = record[record.size - k]

        var result: ListNode?

        if (k == 1) {
            result = ListNode(record.last())
        } else if (k == record.size) {
            result = ListNode(record.last())
        } else {
            result = ListNode(record.first())
        }

        if (record.size == 1) return result
        if (record.size == 2) {
            result = ListNode(record[1])
            result.next = ListNode(record[0])
            return result
        }

        recursive(result, 1)

        return result
    }

    private fun recursive(origin: ListNode?, i: Int) {

        if (i == record.size) {
            return
        }
        if (i == t - 1) {
            origin?.next = ListNode(back)
        } else if (i == record.size - t) {
            origin?.next = ListNode(front)
        } else {
            origin?.next = ListNode(record[i])
        }
        recursive(origin?.next, i + 1)
    }
}

fun main() {
    // [100,24,24,36,18,52,95,61,54,88,86,79,11,1,31,26]
    //16
    val first = SwapNode.ListNode(100)
    first.next = SwapNode.ListNode(24)
    first.next?.next = SwapNode.ListNode(24)
    first.next?.next?.next = SwapNode.ListNode(36)
    first.next?.next?.next?.next = SwapNode.ListNode(18)

    val result = SwapNode.swapNodes(first, 5)
    println(result?.`val`)
    println(result?.next?.`val`)
    println(result?.next?.next?.`val`)
    println(result?.next?.next?.next?.`val`)
    println(result?.next?.next?.next?.next?.`val`)
}