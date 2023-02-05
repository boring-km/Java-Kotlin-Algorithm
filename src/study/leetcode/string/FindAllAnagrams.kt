package study.leetcode.string


object FindAllAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans: MutableList<Int> = ArrayList()
        val count = IntArray(128)
        var required = p.length

        for (c in p.toCharArray()) {
            ++count[c.code]
        }
        var l = 0
        for (r in s.indices){
            if (--count[s[r].code] >= 0) --required
            while (required == 0) {
                if (r - l + 1 == p.length) ans.add(l)
                if (++count[s[l++].code] > 0) ++required
            }
        }

        return ans
    }
}

fun main() {
    val result = FindAllAnagrams.findAnagrams("cbaebabacd", "abc")
    result.forEach { println(it) }
}