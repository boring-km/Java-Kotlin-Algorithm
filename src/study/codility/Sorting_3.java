package study.codility;

import java.util.Arrays;

public class Sorting_3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{}));
    }
    public static int solution(int[] A) {
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersection = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            // upper 보다 작은 lower 들은 반드시 가장 작은 upper 보다 큰 반지름을 갖는다. = 접점
            while (j < N && upper[i] >= lower[j]) {
                intersection += j;
                intersection -= i;
                j++;
            }
        }

        if (intersection > 10000000) return -1;
        return intersection;
    }
}
