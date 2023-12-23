package study.leetcode

object PathCrossing {
    fun isPathCrossing(path: String): Boolean {
        val set = mutableSetOf<Pair<Int, Int>>()
        var x = 0
        var y = 0
        set.add(Pair(x, y))

        path.forEach {
            when (it) {
                'N' -> y++
                'S' -> y--
                'E' -> x++
                'W' -> x--
            }
            if (set.contains(Pair(x, y))) {
                return true
            }
            set.add(Pair(x, y))
        }

        return false
    }
}