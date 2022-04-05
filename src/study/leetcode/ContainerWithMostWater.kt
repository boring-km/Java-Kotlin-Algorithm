package study.leetcode

import kotlin.math.*

// https://leetcode.com/problems/container-with-most-water/
// 풀이: https://leetcode.com/problems/container-with-most-water/discuss/1915108/Python3-GREEDY-TWO-POINTERS-~(~)-Explained
object ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {

        var left = 0
        var right = height.size - 1
        var area = 0

        if (right == 1) {
            return height[0]
        }

        // 끝에서 부터 점점 다가오게끔
        while (left < right) {
            area = max(area, (right - left) * min(height[left], height[right]))
            if (height[left] < height[right]) { // 오른쪽 높이가 더 크면 왼쪽부터 당겨보기
                left++
            } else {    // 왼쪽 높이가 더 크면 오른쪽부터 당겨보기
                right--
            }
        }

        return area
    }
}

fun main() {
    println(ContainerWithMostWater.maxArea(intArrayOf(1, 1)))
}
