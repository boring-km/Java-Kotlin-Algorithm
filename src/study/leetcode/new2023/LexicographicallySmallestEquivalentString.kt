package study.leetcode.new2023


object LexicographicallySmallestEquivalentString {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val letterGroupMap = HashMap<Char, Char>()  // save a to z
        val groupLettersMap = HashMap<Char, MutableSet<Char>>()
        var c = 'a'
        while (c <= 'z') {
            letterGroupMap[c] = c
            val set = HashSet<Char>()
            set.add(c)
            groupLettersMap[c] = set // set에 하나만 저장 (a to z까지)
            c++ // 다음 알파벳
        }
        val length = s1.length
        // s1 길이만큼 s2랑 각 철자별로 비교
        for (i in 0 until length) {
            val char1 = letterGroupMap[s1[i]]!!
            val char2 = letterGroupMap[s2[i]]!!

            // 서로 다르면?
            if (char1 != char2) {
                val set1 = groupLettersMap[char1]!!
                val set2 = groupLettersMap[char2]!!

                // 각자의 set 가져 와서 알파벳 순서가 빠른 알파벳을 순서가 느린 알파벳 위치에 바꿔 넣기
                if (char1 < char2) {
                    for (item in set2) {
                        letterGroupMap[item] = char1
                    }
                    set1.addAll(set2)
                    groupLettersMap[char1] = set1
                    groupLettersMap.remove(char2)
                } else {
                    for (item in set1) {
                        letterGroupMap[item] = char2
                    }
                    set2.addAll(set1)
                    groupLettersMap[char2] = set2
                    groupLettersMap.remove(char1)
                }
            }
        }
        val array = baseStr.toCharArray()
        for (i in array.indices) {
            val item = array[i]
            array[i] = letterGroupMap[item]!!   // 실제로 매핑될 알파벳 철자로 바꾸기
        }
        return String(array)
    }
}
