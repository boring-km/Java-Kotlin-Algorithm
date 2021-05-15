package study.baekjoon.implementation;

import java.util.Scanner;

public class ThrowDice {
    static int[][] board;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        int orderSize = sc.nextInt();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Dice dice = new Dice(x, y, n, m);
        for (int i = 0; i < orderSize; i++) {
            int order = sc.nextInt();
            dice.getRoof(order);
        }
        System.out.println(result.toString());
    }

    static class Dice {
        int x;
        int y;
        int n;
        int m;
        Dice(int x, int y, int n, int m) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.m = m;
        }

        int up = 0;
        int down = 0;
        int front = 0;
        int back = 0;
        int left = 0;
        int right = 0;
        int[][] move = new int[][]{{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 동서북남

        public void getRoof(int order) {
            int tx = x + move[order][1];
            int ty = y + move[order][0];
            if (0 <= tx && tx < m && 0 <= ty && ty < n) {
                int next = board[ty][tx];
                switch (order) {
                    case 1:
                        int tempRight = right;
                        right = up;
                        up = left;
                        left = down;

                        if (next == 0) {
                            board[ty][tx] = tempRight;
                            down = tempRight;
                        }
                        else {
                            down = next;
                            board[ty][tx] = 0;
                        }
                        break;
                    case 2:
                        int tempLeft = left;
                        left = up;
                        up = right;
                        right = down;
                        if (next == 0) {
                            board[ty][tx] = tempLeft;
                            down = tempLeft;
                        }
                        else {
                            down = next;
                            board[ty][tx] = 0;
                        }
                        break;
                    case 3:
                        int tempBack = back;
                        back = up;
                        up = front;
                        front = down;
                        if (next == 0) {
                            board[ty][tx] = tempBack;
                            down = tempBack;
                        }
                        else {
                            down = next;
                            board[ty][tx] = 0;
                        }
                        break;
                    case 4:
                        int tempFront = front;
                        front = up;
                        up = back;
                        back = down;
                        if (next == 0) {
                            board[ty][tx] = tempFront;
                            down = tempFront;
                        }
                        else {
                            down = next;
                            board[ty][tx] = 0;
                        }
                        break;
                }
                x = tx;
                y = ty;
                result.append(up).append("\n");
            }
        }
    }
}
