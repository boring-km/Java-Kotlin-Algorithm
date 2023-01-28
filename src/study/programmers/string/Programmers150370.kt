package study.programmers.string

object Programmers150370 {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {

        val arr = today.split(".")
        val todayValue = arr[0].toInt() * 28 * 12 + arr[1].toInt() * 28 + arr[2].toInt()

        val termMap = HashMap<String, Int>()
        for (term in terms) {
            val temp = term.split(" ")
            termMap[temp[0]] = temp[1].toInt() * 28
        }

        val answer = mutableListOf<Int>()

        for (i in privacies.indices) {
            val privacy = privacies[i]
            val temp = privacy.split(" ")
            val dateArr = temp[0].split(".")
            val type = temp[1]
            val target = dateArr[0].toInt() * 28 * 12 + dateArr[1].toInt() * 28 + dateArr[2].toInt()

            println("$todayValue - ${termMap[type]!!} + $target = ${termMap[type]!! + target - todayValue} ")
            if (todayValue >= termMap[type]!! + target) {
                answer.add(i+1)
            }
        }

        return answer.toIntArray()
    }
}

fun main() {
    val result = Programmers150370.solution(
        "2022.05.19",
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    )

    result.forEach { println(it) }

    val result2 = Programmers150370.solution(
        "2020.01.01",
        arrayOf("Z 3", "D 5"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    )

    result2.forEach { println(it) }
}