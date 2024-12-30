fun recur(list: MutableList<Int>, number: Int, n: Int, m: Int) {
    if (number == m) {
        for (item in list) {
            print("$item ")
        }
        println()
        return
    }
    for (i in 1 ..n) {
        if (list.size > 0 && list.last() > i) continue
        list.add(i)
        recur(list, number+1, n, m)
        list.removeLast()
    }

    return
}


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    recur(mutableListOf(), 0, n, m)
}