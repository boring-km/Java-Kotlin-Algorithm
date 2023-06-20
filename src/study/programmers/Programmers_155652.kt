package study.programmers

object Programmers_155652 {
    fun solution(s: String, skip: String, index: Int): String {
        var answer = ""
        var charList = "abcdefghijklmnopqrstuvwxyz".toMutableList()

        for (item in skip) {
            charList.remove(item)
        }

        for (c in s) {
            var i = charList.indexOf(c)
            i = (i + index) % charList.size
            answer += charList[i]
        }

        return answer
    }
}
