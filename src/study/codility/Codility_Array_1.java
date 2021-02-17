package study.codility;

import java.util.ArrayList;

public class Codility_Array_1 {
    public static void main(String[] args) {
        int[] result = new Solution().solution(new int[]{5, -1000}, 1);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int N = A.length;

        if (N == 0) {   // Codility에서는 빈 Array도 채점에 반영한다...
            return A;
        }

        int move = K % N;

        if (move == 0) {
            if (K >= N) {
                return A;
            } else {
                move = K;
            }
        }
        for (int i = 0; i < move; i++) {
            int temp = A[N-1];
            System.arraycopy(A, 0, A, 1, N - 1);    // Array 자리 이동
            A[0] = temp;
        }

        return A;
    }
}