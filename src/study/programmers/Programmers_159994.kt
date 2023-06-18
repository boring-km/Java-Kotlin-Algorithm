package study.programmers

object Programmers_159994 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var index1 = 0
        var index2 = 0

        var size1 = cards1.size
        var size2 = cards2.size

        for (i in 0 until goal.size) {
            var check = false
            if (index1 < size1 && cards1[index1] == goal[i]) {
                index1++
            } else if (index2 < size2 && cards2[index2] == goal[i]) {
                index2++
            } else {
                return "No"
            }
        }

        return "Yes"
    }
}