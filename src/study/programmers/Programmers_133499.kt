package study.programmers

object Programmers_133499 {
    fun solution(babbling: Array<String>): Int {
        var answer = 0

        for (item in babbling) {
            val left = item.replace("aya", "1").replace("ye", "2")
                .replace("woo", "3").replace("ma", "4")

            if (left.contains("11") || left.contains("22") || left.contains("33") || left.contains("44")) {
                continue
            }
            val final = left.replace("1", "").replace("2", "").replace("3", "").replace("4", "")
            if (final.isEmpty()) {
                answer += 1
            }
        }

        return answer
    }
}

