package study.leetcode

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
object LetterCombinationOfPhoneNumber {
    fun letterCombinations(digits: String): List<String> {

        val list: ArrayList<Array<Char>> = arrayListOf(
            arrayOf(), arrayOf(), arrayOf('a', 'b', 'c'), arrayOf('d', 'e', 'f'), arrayOf('g', 'h', 'i'),
            arrayOf('j', 'k', 'l'), arrayOf('m', 'n', 'o'), arrayOf('p', 'q', 'r', 's'),
            arrayOf('t', 'u', 'v'), arrayOf('w', 'x', 'y', 'z'))

        val items = arrayListOf<Array<Char>>()
        for (char in digits.toCharArray()) {
            items.add(list[char.toString().toInt()])
        }

        return combination(items)
    }

    private fun combination(charArrayList: ArrayList<Array<Char>>): List<String> {
        val result = arrayListOf<String>()
        if (charArrayList.isNotEmpty()) {
            val size = charArrayList.size
            if (size == 1) {
                charArrayList[0].forEach { result.add(it.toString()) }
            } else if (size == 2) {
                for (i in 0 until charArrayList[0].size) {
                    for (j in 0 until charArrayList[1].size) {
                        result.add(charArrayList[0][i].toString() + charArrayList[1][j])
                    }
                }
            } else if (size == 3) {
                for (i in 0 until charArrayList[0].size) {
                    for (j in 0 until charArrayList[1].size) {
                        for (k in 0 until charArrayList[2].size) {
                            result.add(charArrayList[0][i].toString() + charArrayList[1][j] + charArrayList[2][k])
                        }
                    }
                }
            } else {
                for (i in 0 until charArrayList[0].size) {
                    for (j in 0 until charArrayList[1].size) {
                        for (k in 0 until charArrayList[2].size) {
                            for (l in 0 until charArrayList[3].size) {
                                result.add(charArrayList[0][i].toString() + charArrayList[1][j] + charArrayList[2][k] + charArrayList[3][l])
                            }
                        }
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    LetterCombinationOfPhoneNumber.letterCombinations("2")
}