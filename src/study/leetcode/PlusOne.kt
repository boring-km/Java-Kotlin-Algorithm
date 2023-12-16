package study.leetcode

object PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var carry = 1

        for (i in digits.size - 1 downTo 0) {
            val sum = digits[i] + carry
            result.add(sum % 10)
            carry = sum / 10
        }

        if (carry == 1) {
            result.add(1)
        }

        return result.reversed().toIntArray()
    }
}

fun main() {
    val result = PlusOne.plusOne(intArrayOf(9, 9, 9))
    println(result.toList())
}