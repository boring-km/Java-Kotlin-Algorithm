package study.leetcode

// https://leetcode.com/problems/first-bad-version/
abstract class VersionControl {
    val bad = 1702766719

    fun isBadVersion(version: Int): Boolean {
        return bad <= version
    }

    abstract fun firstBadVersion(n: Int): Int
}

object FirstBadVersion: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var start: Long = 1
        var end: Long = n.toLong()
        var result: Int = n

        while (end - start >= 0) {
            val mid: Long = (start + end) / 2

            if (isBadVersion(mid.toInt())) {
                end = mid - 1
                result = mid.toInt()
            } else {
                start = mid + 1
            }
        }
        return result
    }
}

fun main() {
    val result = FirstBadVersion.firstBadVersion(2126753390)
    println(result)
}