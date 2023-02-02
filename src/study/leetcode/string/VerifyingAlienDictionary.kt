package study.leetcode.string

object VerifyingAlienDictionary {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {

        val n = words.size
        if (n == 1) return true

        val orders = order.toCharArray()
        val orderMap = HashMap<Char, Int>()
        for (i in orders.indices) {
            orderMap[orders[i]] = i
        }


        val list = Array(n){ mutableListOf<Int>() }

        for (i in list.indices) {
            for (c in words[i]) {
                list[i].add(orderMap[c]!!)
            }
        }

        var result = true
        for (i in 0 until n - 1) {
            result = result && compare(list[i], list[i+1])
        }

        return result
    }

    private fun compare(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        val minSize = Math.min(a.size, b.size)

        var equalCount = 0
        for (i in 0 until minSize) {
            if (a[i] > b[i]) {
                return false
            } else if (a[i] == b[i]) equalCount++ else {
                return true
            }
        }
        return !(equalCount == minSize && a.size > b.size)
    }
}

fun main() {
    val result = VerifyingAlienDictionary.isAlienSorted(arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz")
    println(result)
}