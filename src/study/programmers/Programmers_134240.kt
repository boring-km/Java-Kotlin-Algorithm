package study.programmers

object Programmers_134240 {
    fun solution(food: IntArray): String {

        var temp = ""
        for (i in food.indices) {
            if (i == 0) continue
            val num = food[i] / 2
            temp += "$i".repeat(num)
        }

        return temp + "0" + temp.reversed()
    }
}

fun main() {
    val result = Programmers_134240.solution(intArrayOf(1, 7, 1, 2))
    println(result)
}