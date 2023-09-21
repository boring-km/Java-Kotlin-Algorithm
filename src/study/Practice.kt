package study

fun containsEven(arr: List<List<Int>>): Boolean {
    for (x in arr.indices) {
        for (y in arr[x].indices) {
            if (arr[x][y] % 2 == 0) {
                return true
            }
        }
    }
    return false
}

fun minimum(arr: List<List<Int>>): Int {
    var result = Int.MAX_VALUE
    arr.forEach { it.forEach { result = it.coerceAtMost(result) } }
    return result
}
fun main() {

}