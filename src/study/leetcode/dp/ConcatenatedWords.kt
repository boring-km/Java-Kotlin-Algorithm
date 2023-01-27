package study.leetcode.dp

import java.util.*


object ConcatenatedWords {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val ans = mutableListOf<String>()
        val wordSet = HashSet(mutableListOf(*words))
        val memo = HashMap<String, Boolean>()   // 정답 여부 기록

        for (word in words) {
            if (recursive(word, wordSet, memo)) {
                ans.add(word)
            }
        }
        return ans
    }

    private fun recursive(word: String, wordSet: Set<String>, memo: MutableMap<String, Boolean>): Boolean {
        if (memo.containsKey(word)) return memo[word]!!
        for (i in 1 until word.length) {
            val prefix = word.substring(0, i)
            val suffix = word.substring(i)
            if (wordSet.contains(prefix) &&
                (wordSet.contains(suffix) || recursive(suffix, wordSet, memo))
            ) {
                memo[word] = true
                return true
            }
        }
        memo[word] = false
        return false
    }
}

fun main() {
    val result = ConcatenatedWords.findAllConcatenatedWordsInADict(arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"))
    result.forEach { println(it) }

    val result2 = ConcatenatedWords.findAllConcatenatedWordsInADict(arrayOf("a","b","ab","abc"))
    result2.forEach { println(it) }

    // "a","b","ab","abc"
}