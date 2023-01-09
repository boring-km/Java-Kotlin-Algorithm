package study.leetcode.new2023

object MaxPointsOnALIne {
    fun maxPoints(points: Array<IntArray>): Int {

        var max = 0

        for (i in points.indices) {
            val map = hashMapOf<Double, Int>()

            for (j in points.indices) {
                val prev = points[i]
                val post = points[j]
                if (prev.contentEquals(post)) continue
                val slope = (post[0] - prev[0]).toDouble() / (post[1] - prev[1]) // 기울기
                map[slope] = map.getOrDefault(slope, 0) + 1
                max = max.coerceAtLeast(map.getOrDefault(slope, 0))
            }
        }

        return max + 1
    }
}