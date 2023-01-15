package study.leetcode.new2023


object LexicographicallySmallestEquivalentString {

    // union find로 재풀이
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {

        val unionFind = UnionFind()

        for (i in s1.indices) {
            val c1 = s1[i]
            val c2 = s2[i]
            unionFind.union(c1, c2)
        }

        val sb = StringBuilder()
        for (char in baseStr.toCharArray()) {
            sb.append('a' + unionFind.find(char))
        }
        return sb.toString()
    }

    class UnionFind {
        private val arr = IntArray(26) { i -> i }

        fun union(a: Char, b: Char) {
            val x = find(a)
            val y = find(b)
            if (x < y) {
                arr[y] = x
            } else {
                arr[x] = y
            }
        }

        fun find(x: Char): Int {
            var t = x
            while (t - 'a' != arr[t - 'a']) {
                arr[t - 'a'] = arr[arr[t - 'a']]
                t = (arr[t - 'a'] + 'a'.code).toChar()
            }
            return t - 'a'
        }
    }
}
