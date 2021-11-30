package study.programmers.practice;

public class MiniRectangle {
    public static void main(String[] args) {
        int result = solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(result);
    }

    public static int solution(int[][] sizes) {
        int big = 1;
        int small = 1;

        for (int[] item : sizes) {
            if (item[0] > item[1]) {
                big = Math.max(big, item[0]);
                small = Math.max(small, item[1]);
            } else {
                big = Math.max(big, item[1]);
                small = Math.max(small, item[0]);
            }
        }
        return big * small;
    }
}
