package study.leetcode.string

object GreatestCommonDivisorStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        var answer = ""

        val target = if (str1.length > str2.length) str1 else str2

        for (i in 1 .. target.length) {
            val s = StringBuilder()
            val temp = target.substring(0, i)

            if (str1.length % temp.length == 0 && str2.length % temp.length == 0) {

                for (k in 0 until (str1.length / temp.length)) {
                    s.append(temp)
                }
                var result = s.toString() == str1
                s.clear()

                for (k in 0 until (str2.length / temp.length)) {
                    s.append(temp)
                }

                result = result && s.toString() == str2

                if (result) {
                    answer = temp
                }
            }
        }


        return answer
    }
}