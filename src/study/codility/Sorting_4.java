package study.codility;

import java.util.Arrays;

public class Sorting_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 4, 5, 6}));
    }
    public static int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < N-2; i++) {
            if ((long)A[i] + (long)A[i+1] > (long)A[i+2]) {
                return 1;
            }
        }
        return 0;
    }
}
