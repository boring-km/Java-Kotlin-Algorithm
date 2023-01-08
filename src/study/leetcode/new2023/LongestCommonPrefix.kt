package study.leetcode.new2023

// https://leetcode.com/problems/longest-common-prefix/
object LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {

        var answer = ""
        for (i in 1..200) {
            var clear = true
            val firstItem = strs[0]
            if (strs.size == 1) return firstItem
            if (firstItem.length < i) break

            val first = firstItem.substring(0, i)

            for (j in 1 until strs.size) {
                val str = strs[j]
                if (i > str.length) {
                    clear = false
                    break
                }

                if (str.substring(0, i) != first) {
                    clear = false
                    break
                }
            }

            if (clear) {
                answer = firstItem.substring(0, i)
            }
        }

        return answer
    }
}
