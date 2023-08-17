package study.programmers

import java.util.HashMap

object Programmers_118666 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        val map = HashMap<Char, Int>()


        for (i in survey.indices) {
            val choice = choices[i]
            val s = survey[i]

            val order = s.toCharArray()
            if (choice > 4) {
                map[order[1]] = map.getOrDefault(order[1], 0) + choice - 4
            } else if (choice < 4) {
                map[order[0]] = map.getOrDefault(order[0], 0) + 4 - choice
            }
        }

        val s1 = map.getOrDefault('R', 0).compareTo(map.getOrDefault('T', 0))
        val s2 = map.getOrDefault('C', 0).compareTo(map.getOrDefault('F', 0))
        val s3 = map.getOrDefault('J', 0).compareTo(map.getOrDefault('M', 0))
        val s4 = map.getOrDefault('A', 0).compareTo(map.getOrDefault('N', 0))

        answer += if (s1 > 0) "R"
        else if (s1 < 0) "T"
        else "R"

        answer += if (s2 > 0) "C"
        else if (s2 < 0) "F"
        else "C"

        answer += if (s3 > 0) "J"
        else if (s3 < 0) "M"
        else "J"

        answer += if (s4 > 0) "A"
        else if (s4 < 0) "N"
        else "A"

        return answer
    }
}

fun main() {
    println(Programmers_118666.solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)))
}