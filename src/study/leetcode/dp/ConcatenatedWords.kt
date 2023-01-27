package study.leetcode.dp

object ConcatenatedWords {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {

        val map = HashMap<String, Boolean>()
        words.forEach { map[it] = true }

        val answer = mutableListOf<String>()

        for (word in words) {
            var total = ""
            var cur = ""
            var count = 0
            var temp = false

            for (c in word) {
                // 포함되는 걸 찾았다면 -> 근데 더 긴 key도 있을 수 있는데?
                val key = cur + c
                if (map.containsKey(key)) {
                    if (temp && map.containsKey(c.toString())) {
                        count++
                    }
                    if (total + key == word) {
                        count++
                        total += key
                    }
                    temp = true
                    cur = key
                    continue
                } else if (!map.containsKey(key) && temp) {
                    count++
                    total += cur
                    cur = c.toString()
                    temp = false
                } else {
                    // 한글자씩 더하기
                    cur += c
                }
            }

            if (count >= 2 && total == word) {
                answer.add(word)
            }

        }

        return answer
    }
}

fun main() {
    val result = ConcatenatedWords.findAllConcatenatedWordsInADict(arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"))
    result.forEach { println(it) }

    val result2 = ConcatenatedWords.findAllConcatenatedWordsInADict(arrayOf("a","b","ab","abc"))
    result2.forEach { println(it) }

    // "a","b","ab","abc"
}