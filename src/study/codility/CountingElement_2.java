package study.codility;

import java.util.Arrays;

public class CountingElement_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] board = new int[N];
        int maxi = 0;

        for (int index : A) {
            if (index > N) {    // max counter
                Arrays.fill(board, maxi);
            } else {    // increase(X)
                int target = index - 1;
                board[target] += 1;
                maxi = Math.max(maxi, board[target]);
            }
        }

        return board;
    }
}
