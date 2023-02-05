package study.leetcode.string

object FindAllAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()

        val n = s.length
        val m = p.length

        val map = HashMap<Char, Int>()
        for (c in p) {
            if (map.containsKey(c)) {
                map[c] = map[c]!! + 1
            } else {
                map[c] = 1
            }
        }

        for (i in 0 .. n - m) {
            val temp = HashMap<Char, Int>()
            for (c in s.substring(i, i+m)) {
                if (temp.containsKey(c)) {
                    temp[c] = temp[c]!! + 1
                } else {
                    temp[c] = 1
                }
            }
            if (isEqual(map, temp)) {
                result.add(i)
            }
        }

        return result
    }

    private fun isEqual(
        map: HashMap<Char, Int>,
        temp: HashMap<Char, Int>
    ): Boolean {
        var check = true
        for (key in map.keys) {
            if (map[key] != temp[key]) {
                check = false
                break
            }
        }
        return check
    }
}

fun main() {
    val result = FindAllAnagrams.findAnagrams("cbaebabacd", "abc")
    result.forEach { println(it) }
}