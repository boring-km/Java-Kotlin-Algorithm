package study.codility;

import java.util.Arrays;

public class Codility_Array_2 {
    public static void main(String[] args) {
        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int answer = 0;

        for (int i = 0, len = A.length; i < len; i += 2) {
            if (i == len-1) {
                answer = A[i];
                break;
            }
            if (A[i] != A[i+1]) {
                answer = A[i];
                break;
            }
        }
        return answer;
    }
}
