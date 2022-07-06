package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/12946
// https://shoark7.github.io/programming/algorithm/tower-of-hanoi
object HanoisTop {
    val list = arrayListOf<Array<Int>>()

    fun solution(n: Int): Array<IntArray> {

        hanoi(n, 1, 3, 2)

        val answer = Array(list.size) { IntArray(0) }

        for (i in list.indices) {
            val temp: Array<Int> = list[i]
            val t = IntArray(temp.size)
            for (j in temp.indices) {
                t[j] = temp[j]
            }
            answer[i] = t
        }

        return answer
    }

    private fun hanoi(n: Int, start: Int, to: Int, via: Int) {
        if (n == 1) {
            move(1, start, to)  // 1은 목적지로 이동한다.
        } else {
            hanoi(n-1, start, via, to)  // 재귀로 첫번째 원판까지 이동 (목적지를 중간지점이 계속 왔다 갔다 변경)
            move(n, start, to)  // 1을 옮기고 나면 그 다음 번호 원판을 이동
            hanoi(n-1, via, to, start)  // 이동된 1을 도착지점에서 중간 지점으로 하고 처음 위치가 중간 지점이 된다.
        }
    }
    // (1,2,3) () ()
    // (2,3) () (1)
    // (3) (2) (1)
    // (3) (1,2) ()
    // () (1,2) (3)
    // (1) (2) (3)
    // (1) () (2,3)
    // () () (1,2,3)

    private fun move(n: Int, start: Int, to: Int){
        println("${n}번 원반을 ${start}에서 ${to}로 이동")
        list.add(arrayOf(start, to))
    }
}

fun main() {
    val result = HanoisTop.solution(3)
    result.forEach {
        run {
            it.forEach { n -> print("$n ") }
            println()
        }
    }
}