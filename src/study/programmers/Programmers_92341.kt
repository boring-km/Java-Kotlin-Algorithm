package study.programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
private fun solution(fees: IntArray, records: Array<String>): IntArray {
    val limit = fees[0]
    val base = fees[1]
    val term = fees[2]
    val extraFee = fees[3]

    val carMap = HashMap<String, Int>()
    val totalMap = HashMap<String, Int>()
    val keys = HashMap<String, Int>()

    for (record in records) {
        val items = record.split(" ")

        val times = items[0].split(":")
        val time = times[0].toInt() * 60 + times[1].toInt()

        val car = items[1]
        keys[car] = 0

        val isIn = items[2] == "IN"

        if (isIn) {
            carMap[car] = time
            println("in: $time")
        } else {
            val duration = time - carMap[car]!!
            if (totalMap.containsKey(car)) {
                totalMap[car] = totalMap[car]!! + duration
            } else {
                totalMap[car] = duration
            }
            carMap.remove(car)
        }
    }

    val tempList = arrayListOf<Int>()
    for (key in keys.keys.sorted()) {
        var total = 0.0
        if (totalMap.containsKey(key)) {
            total = totalMap[key]!!.toDouble()
        }
        if (carMap[key] != null) {
            total += 23 * 60 + 59 - carMap[key]!!
        }
        if (total <= limit) {
            tempList.add(base)
        } else {
            tempList.add((base + Math.ceil((total - limit) / term) * extraFee).toInt())
        }
    }

    return tempList.toIntArray()
}

fun main() {
    val message = solution(intArrayOf(1, 461, 1, 10),
        arrayOf("00:00 1234 IN"))
    for (i in message) {
        println(i)
    }
}