package study.baekjoon.bruteforce;

import java.util.Scanner;

public class NQueen {

    private static final int[] board = new int[15];
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        recursive(0, n);
        System.out.println(result);
    }

    private static void recursive(int count, int n) {
        if (count == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[count] = i;
            boolean check = true;
            for (int j = 0; j < count; j++) {
                if (board[count] == board[j] ||
                        count - j == Math.abs(board[count] - board[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                recursive(count+1, n);
            }
        }
    }
}
