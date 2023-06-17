package study.programmers

object Programmers_161990 {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        val h = wallpaper.size
        val w = wallpaper[0].length

        var startX = w
        var startY = h
        var endX = 0
        var endY = 0


        for (i in 0 until h) {
            for (j in 0 until w) {
                if (wallpaper[i][j] == '#') {
                    startY = Math.min(i, startY)
                    startX = Math.min(j, startX)
                    endY = Math.max(i, endY)
                    endX = Math.max(j, endX)
                }
            }
        }

        return intArrayOf(startY, startX, endY+1, endX+1)
    }
}