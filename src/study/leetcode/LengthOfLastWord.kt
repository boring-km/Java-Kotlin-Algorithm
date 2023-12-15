package study.leetcode

object LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val arr = s.split(" ")

        for (i in arr.size - 1 downTo 0) {
            if (arr[i].isNotEmpty()) {
                return arr[i].length
            }
        }

        return 1
    }
}

fun main() {
    val result = LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  ")
    println(result)
}