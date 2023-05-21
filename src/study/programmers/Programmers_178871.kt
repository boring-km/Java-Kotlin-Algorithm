package study.programmers

object Programmers_178871 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val map = HashMap<String, Int>()
        for (i in players.indices) {
            map[players[i]] = i
        }

        for (calling in callings) {
            val target = map[calling]!!   // 추월한 인덱스: 반드시 0보다 크다 (1등은 안부름)
            val changedPlayerName = players[target-1]

            players[target] = changedPlayerName
            players[target-1] = calling
            map[changedPlayerName] = target
            map[calling] = target - 1
        }

        return players
    }
}

fun main() {
    val result = Programmers_178871.solution(arrayOf("mumu", "soe", "poe", "kai", "mine"), arrayOf("kai", "kai", "mine", "mine"))
    for (item in result) {
        print("$item ")
    }
}