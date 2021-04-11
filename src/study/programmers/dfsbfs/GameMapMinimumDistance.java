package study.programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// 15분 정도 걸림
public class GameMapMinimumDistance {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
        }));
    }

    public static int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int y = next[0];
            int x = next[1];
            int dist = next[2];

            if (y == n-1 && x == m-1) {
                answer = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ty = y + move[i][0];
                int tx = x + move[i][1];
                if (ty < 0 || ty >= n || tx < 0 || tx >= m) {
                    continue;
                }
                if (maps[ty][tx] == 1 && !visited[ty][tx]) {
                    visited[ty][tx] = true;
                    queue.add(new int[]{ty, tx, dist+1});
                }
            }
        }

        return answer;
    }
}
