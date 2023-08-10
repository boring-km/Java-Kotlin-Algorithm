package study.programmers

fun solution(a: Int, b: Int, n: Int): Int {

    var emptyBottle = n
    var drink = 0

    while (emptyBottle >= a) {

        val remain = emptyBottle % a
        emptyBottle = (emptyBottle / a) * b
        drink += emptyBottle
        emptyBottle += remain
    }

    return drink
}

fun main() {
    val a = 2  // 빈 병 a개를 가져다 줄 때 얻는 음료 개수
    val b = 1  // 음료 병 b개를 가져다 줄 때 얻는 음료 개수
    val n = 20  // 상빈이가 가지고 있는 빈 병 개수

    val result = solution(a, b, n)
    println("상빈이가 받을 수 있는 음료 개수: $result")
}
