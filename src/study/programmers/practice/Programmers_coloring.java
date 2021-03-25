package study.programmers.practice;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_coloring {
    public static void main(String[] args) {
        int[] result = solution(5, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] moveX = new int[]{1, -1, 0, 0};
        int[] moveY = new int[]{0, 0, -1, 1};

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int target = picture[i][j];
                if (target == 0 || visited[i][j])
                    continue;
                Queue<Integer> qx = new LinkedList<>();
                Queue<Integer> qy = new LinkedList<>();
                qx.add(j);
                qy.add(i);
                int tempArea = 0;
                numberOfArea++;
                while (!qx.isEmpty() && !qy.isEmpty()) {
                    int tx = qx.poll(), ty = qy.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = tx + moveX[k], y = ty + moveY[k];
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            continue;
                        }
                        if (picture[y][x] == target && !visited[y][x]) {
                            visited[y][x] = true;
                            qx.add(x);  qy.add(y);
                            tempArea++;
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempArea);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
