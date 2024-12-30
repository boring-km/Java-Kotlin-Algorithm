package study.baekjoon.backtracking



fun main() {
    val n = readln().toInt()
    val hint: MutableList<List<Int>> = mutableListOf()
    for (i in 0 until n) {
        hint.add(readln().split(" ").map { it.toInt() })
    }
    var answer = 0

    fun check(index: Int, number: Int): Boolean {
        val _number = hint[index][0]
        val _strike = hint[index][1]
        val _ball = hint[index][2]

        var strike = 0
        var ball = 0

        val _a = _number / 100
        val _b = (_number - (_a * 100)) / 10
        val _c = _number % 10

        val a = number / 100
        val b = (number - (a * 100)) / 10
        val c = number % 10

        if (a == 0 || b == 0 || c == 0) return false
        if (a == b || b == c || a == c) return false

        if (_a == a) strike++
        if (_b == b) strike++
        if (_c == c) strike++

        if (_a == b || _a == c) ball++
        if (_b == a || _b == c) ball++
        if (_c == a || _c == b) ball++

        if (strike == _strike && ball == _ball) return true

        return false
    }

    fun recur(hintIndex: Int, number: Int) {
        if (hintIndex == n) {
            answer++
            recur(0, number+1)
            return
        }

        if (number == 988) return

        if (check(hintIndex, number)) {
            recur(hintIndex+1, number)
        } else {
            recur(0, number+1)
        }
    }

    recur(0, 123)
    println(answer)

}