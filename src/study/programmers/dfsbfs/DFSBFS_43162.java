package study.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// 33분 33초
public class DFSBFS_43162 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (visited[i][i]) {
                continue;
            }
            Queue<Integer> qx = new LinkedList<>();
            qx.add(i);
            while (!qx.isEmpty()) {
                int x = qx.poll();
                for (int j = 0; j < n; j++) {
                    if (computers[x][j] == 1 && !visited[x][j]) {
                        if (x != j) {
                            qx.add(j);
                        }
                        visited[x][j] = true;
                        visited[j][x] = true;
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
