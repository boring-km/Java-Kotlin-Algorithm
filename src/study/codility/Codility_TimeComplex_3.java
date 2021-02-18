package study.codility;

import java.util.Arrays;

public class Codility_TimeComplex_3 {
    // 92 %
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1000, 1000}));
    }
    public static int solution(int[] A) {
        int answer = 1000000;
        int total = Arrays.stream(A).sum();

        int first = 0;
        int second;
        for (int j = 0, len = A.length; j < len - 1; j++) {
            first += A[j];
            second = total - first;
            answer = Math.min(answer, Math.abs(second - first));
        }
        return answer;
    }
}
