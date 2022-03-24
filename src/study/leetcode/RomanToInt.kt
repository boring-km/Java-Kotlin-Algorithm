package study.leetcode

// https://leetcode.com/problems/roman-to-integer
object RomanToInt {
    fun romanToInt(s: String): Int {
        var text = s
        var result = 0

        while (text.isNotEmpty()) {
            if (text.contains("CM")) {
                text = text.replaceFirst("CM", "")
                result += 900
            } else if (text.contains("CD")) {
                text = text.replaceFirst("CD", "")
                result += 400
            } else if (text.contains("XC")) {
                text = text.replaceFirst("XC", "")
                result += 90
            } else if (text.contains("XL")) {
                text = text.replaceFirst("XL", "")
                result += 40
            } else if (text.contains("IX")) {
                text = text.replaceFirst("IX", "")
                result += 9
            } else if (text.contains("IV")) {
                text = text.replaceFirst("IV", "")
                result += 4
            } else if (text.contains("M")) {
                text = text.replaceFirst("M", "")
                result += 1000
            } else if (text.contains("D")) {
                text = text.replaceFirst("D", "")
                result += 500
            } else if (text.contains("C")) {
                text = text.replaceFirst("C", "")
                result += 100
            } else if (text.contains("L")) {
                text = text.replaceFirst("L", "")
                result += 50
            } else if (text.contains("X")) {
                text = text.replaceFirst("X", "")
                result += 10
            } else if (text.contains("V")) {
                text = text.replaceFirst("V", "")
                result += 5
            } else if (text.contains("I")) {
                text = text.replaceFirst("I", "")
                result += 1
            } else continue
        }

        return result
    }
}

fun main() {
   val result = RomanToInt.romanToInt("LVIII")
    println(result)
}