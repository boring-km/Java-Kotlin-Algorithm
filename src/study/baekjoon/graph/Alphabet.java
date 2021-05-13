package study.baekjoon.graph;

import java.util.*;

public class Alphabet {
    private static char[][] board;
    private static int answer = 0;
    private static int r;
    private static int c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = scanner.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        recursive(0, 0, String.valueOf(board[0][0]));
        System.out.println(answer);
    }

    private static void recursive(int y, int x, String cur) {

        answer = Math.max(answer, cur.length());

        int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int ty = y + move[i][0];
            int tx = x + move[i][1];
            if (0 <= ty && ty < r && 0 <= tx && tx < c) {
                boolean isVisited = false;
                for (int j = 0; j < cur.length(); j++) {
                    if (board[ty][tx] == cur.charAt(j)) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    recursive(ty, tx, cur + board[ty][tx]);
                }
            }
        }
    }
}
