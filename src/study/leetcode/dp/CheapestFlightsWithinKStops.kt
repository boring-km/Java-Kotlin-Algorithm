package study.leetcode.dp


// 실패
// https://github.com/Cee/Leetcode/blob/master/787%20-%20Cheapest%20Flights%20Within%20K%20Stops.java
object CheapestFlightsWithinKStops {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // dp -> 비용 기록 array
        var prices = IntArray(n) { Int.MAX_VALUE }
        prices[src] = 0 // 현재 0
        for (i in 0..k) {   // k번 이동해야 한다. 무조건
            val tempPrices = prices.clone()   // for문 돌면서 변경될 비용 기록
            for (flight in flights) {
                val cur = flight[0]
                val next = flight[1]
                val price = flight[2]
                if (prices[cur] == Int.MAX_VALUE) continue  // 변경 기록 안함
                // 다음 기록은 현재 값에서 + price이 다음으로 이동하려는 다른 변경보다 작은 비용일 때 변경됨
                tempPrices[next] = tempPrices[next].coerceAtMost(prices[cur] + price)
            }
            // 변경 기록 저장
            prices = tempPrices
        }
        // 도달하지 못했다면 -1, 도달했다면 그 값 리턴
        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
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