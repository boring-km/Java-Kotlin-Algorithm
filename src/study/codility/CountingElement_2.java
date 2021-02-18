package study.codility;

import java.util.Arrays;

public class CountingElement_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] board = new int[N];
        int max = 0;
        int max_record = 0;

        for (int index : A) {
            if (index == N + 1) {    // max counter 하지 않고 현재 최대값 저장
                max_record = max;
            } else {                 // increase(X)
                int target = index - 1;
                if (max_record >= board[target]) {
                    board[target] = max_record + 1;     // max 값을 반영은 해야하니까
                } else {
                    board[target] += 1;
                }
                max = Math.max(max, board[target]);
            }
        }

        // max count를 한번만 세팅, 이미 max가 추가가 된 인덱스에는 추지 않음
        for (int i = 0; i < board.length; i++) {
            if (max_record > 0 && max_record > board[i]) {
                board[i] = max_record;
            }
        }

        return board;
    }
}
