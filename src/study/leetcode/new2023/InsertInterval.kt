package study.leetcode.new2023

object InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }
        val n = Math.max(intervals.last()[1], newInterval[1])
        val graph = HashMap<Int, MutableList<Int>>()

        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]

            for (i in start .. end) {
                if (graph.containsKey(i)) {
                    graph[i]!!.add(i)
                } else {
                    graph[i] = mutableListOf(i)
                }
                if (i != end) {
                    graph[i]!!.add(i+1)
                }
            }
        }
        for (i in newInterval[0] .. newInterval[1]) {
            if (graph.containsKey(i)) {
                graph[i]!!.add(i)
            } else {
                graph[i] = mutableListOf(i)
            }
            if (i != newInterval[1]) {
                graph[i]!!.add(i+1)
            }
        }

        var cur = false
        var start = -1
        val result = mutableListOf<IntArray>()
        for (i in 0..n) {
            if (!cur && (graph[i]?.contains(i+1) == true || graph[i]?.contains(i) == true)) {
                cur = true
                start = i
            }
            if (cur && graph[i]?.contains(i+1) != true) {
                cur = false
                result.add(intArrayOf(start, i))
            }
        }

        return result.toTypedArray()
    }
}