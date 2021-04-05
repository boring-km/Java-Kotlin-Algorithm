package study.programmers.practice;

import java.util.Arrays;

// 1시간 44분
public class QuadCompression {
    public static void main(String[] args) {
        // {1, 1, 1, 1, 1, 1, 1, 1},
        // {0, 1, 1, 1, 1, 1, 1, 1},
        // {0, 0, 0, 0, 1, 1, 1, 1},
        // {0, 1, 0, 0, 1, 1, 1, 1},
        // {0, 0, 0, 0, 0, 0, 1, 1},
        // {0, 0, 0, 0, 0, 0, 0, 1},
        // {0, 0, 0, 0, 1, 0, 0, 1},
        // {0, 0, 0, 0, 1, 1, 1, 1}
        int[] res = solution(new int[][]{
                {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}
        });
        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] solution(int[][] arr) {
        int n = arr.length;
        return fourWay(0, 0, n, n, arr, n);
    }

    private static int[] fourWay(int sy, int sx, int ey, int ex, int[][] arr, int n) {
        int[] result = new int[2];
        n /= 2;
        int[] leftup = recursive(sy, sx, sy+n, sx+n, arr, n);
        int[] rightup = recursive(sy, sx+n, sy+n, ex, arr, n);
        int[] leftdown = recursive(sy+n, sx, ey, sx+n, arr, n);
        int[] rightdown = recursive(sy+n, sx+n, ey, ex, arr, n);
        for (int i = 0; i < 2; i++) {
            result[i] += leftup[i];
            result[i] += rightup[i];
            result[i] += leftdown[i];
            result[i] += rightdown[i];
        }
        if (result[0] == 4 && result[1] == 0) result[0] = 1;
        else if (result[0] == 0 && result[1] == 4) result[1] = 1;
        return result;
    }

    private static int[] recursive(int sy, int sx, int ey, int ex, int[][] arr, int n) {
        int[] result = new int[2];
        int count = 0;
        for (int j = sy; j < ey; j++) {
            for (int k = sx; k < ex; k++) {
                count += arr[j][k];
            }
        }
        if (count == 0) {
            result[0] += 1;
        } else if (count == n*n) {
            result[1] += 1;
        } else {
            if (n == 1) {
                result[0] += n*n - count;
                result[1] += count;
            } else {
                result = fourWay(sy, sx, ey, ex, arr, n);
            }
        }
        return result;
    }
}
