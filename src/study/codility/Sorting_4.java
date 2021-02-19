package study.codility;

import java.util.Arrays;

public class Sorting_4 {
    public static void main(String[] args) {

    }
    public static int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < N-2; i++) {
            if (A[i] + A[i+1] > A[i+2]) {
                return 1;
            }
        }
        return 0;
    }
}
