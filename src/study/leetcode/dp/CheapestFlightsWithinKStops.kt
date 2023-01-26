package study.leetcode.dp

import java.util.*


// 실패
// https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/2825208/cheapest-flights-within-k-stops/
object CheapestFlightsWithinKStops {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = HashMap<Int, MutableList<IntArray>>()
        for (flight in flights) {
            graph.computeIfAbsent(flight[0]) { ArrayList() }.add(intArrayOf(flight[1], flight[2]))
        }

        return bfs(n, src, k, graph, dst)
    }

    private fun bfs(
        n: Int,
        src: Int,
        k: Int,
        graph: HashMap<Int, MutableList<IntArray>>,
        dst: Int
    ): Int {
        val priceArray = IntArray(n) { Int.MAX_VALUE }

        val queue: Deque<IntArray> = LinkedList()
        queue.offer(intArrayOf(src, 0))
        var stops = 0

        // 무조건 k번 들려야한다.
        while (stops <= k && !queue.isEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val temp = queue.poll()

                val current = temp[0]
                val distance = temp[1]
                // 더이상 이동할 곳이 없다면
                if (!graph.containsKey(current)) continue

                // 연결된 노드들
                for (nextNode in graph[current]!!) {
                    val position = nextNode[0]
                    val price = nextNode[1]
                    // 비용이 더 크면 이동하지 않음
                    if (distance + price >= priceArray[position]) continue
                    // 비용 업데이트
                    priceArray[position] = distance + price
                    // 다음 포지션 확인
                    queue.offer(intArrayOf(position, priceArray[position]))
                }
            }
            stops++
        }
        return if (priceArray[dst] == Int.MAX_VALUE) -1 else priceArray[dst]
    }
}

fun main() {
    val result = CheapestFlightsWithinKStops.findCheapestPrice(
        3,
        arrayOf(
            intArrayOf(0, 1, 100),
            intArrayOf(1, 2, 100),
            intArrayOf(0, 2, 500)
        ),
        0,
        2,
        1
    )
    println(result)

//    val result2 = CheapestFlightsWithinKStops.findCheapestPrice(
//        4,
//        arrayOf(
//            intArrayOf(0, 1, 100),
//            intArrayOf(1, 2, 100),
//            intArrayOf(2, 0, 100),
//            intArrayOf(1, 3, 600),
//            intArrayOf(2, 3, 200)
//        ),
//        0,
//        3,
//        1
//    )
//    println(result2)
}