package study.programmers


class Programmers_160586 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {

        val n = targets.size
        val answer = IntArray(n)

        val temp = HashMap<Char, Int>()

        for (k in 0 until keymap.size) {
            val keyStr = keymap[k]

            for (i in keyStr.indices) {
                if (temp.contains(keyStr[i])) {
                    temp[keyStr[i]] = Math.min(temp[keyStr[i]]!!, i+1)
                } else {
                    temp[keyStr[i]] = i + 1
                }
            }
        }

        for (k in 0 until n) {
            val target = targets[k]

            var answerItem = 0

            for (i in target.indices) {
                if (!temp.contains(target[i])) {
                    answerItem = -1
                    break
                } else {
                    answerItem += temp[target[i]]!!
                }
            }
            answer[k] = answerItem
        }

        return answer
    }
}

