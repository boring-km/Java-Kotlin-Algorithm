package study.leetcode

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
object RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val target = findLength(head) - n
        if (target == 0) {
            return if (n == 1) null else head?.next
        }
        val copy = ListNode(head?.`val`!!)
        recursive(copy, head, 1, target, target + n)
        return copy
    }

    private fun recursive(curNode: ListNode?, original: ListNode?, count: Int, target: Int, length: Int) {
        if (count == length) {
            return
        }
        if (count < target || target < count) {
            val newNodeValue: Int? = original?.next?.`val`
            curNode?.next = ListNode(newNodeValue!!)
            recursive(curNode?.next, original?.next, count + 1, target, length)
        } else {
            recursive(curNode, original?.next, count + 1, target, length)
        }
    }

    private fun findLength(head: ListNode?): Int {
        var temp = head
        var length = 0
        while (temp != null) {
            length++
            temp = temp.next
        }
        return length
    }
}

fun main() {
    val first = ListNode(1)
    first.next = ListNode(2)
    first.next?.next = ListNode(3)
    first.next?.next?.next = ListNode(4)
    first.next?.next?.next?.next = ListNode(5)
    var result = RemoveNthNodeFromEndOfList.removeNthFromEnd(first, 2)
    while (result?.`val` != null) {
        println(result.`val`)
        result = result.next
    }
}