package study.programmers.graph;

import java.util.LinkedList;
import java.util.Queue;

// 1시간 20분 -> 시간초과 (정확성 78.1%)
public class Delivery {
    public static void main(String[] args) {
        System.out.println(solution(
                5,
                new int[][]{
                        {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
                },
                3
        ));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 1;

        int[][] graph = new int[N + 1][N + 1];
        for (int[] item : road) {
            if (graph[item[0]][item[1]] != 0) {
                graph[item[0]][item[1]] = Math.min(graph[item[0]][item[1]], item[2]);
                graph[item[1]][item[0]] = Math.min(graph[item[1]][item[0]], item[2]);
            } else {
                graph[item[0]][item[1]] = item[2];
                graph[item[1]][item[0]] = item[2];
            }
        }
        int start = 1;
        for (int end = 2; end <= N; end++) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> lenQueue = new LinkedList<>();
            queue.add(start);
            lenQueue.add(0);
            while (!queue.isEmpty()) {
                int next = queue.poll();
                int length = lenQueue.poll();
                if (length > K) {
                    continue;
                }
                if (next == end) {
                    if (length <= K) answer++;
                    break;
                }
                for (int i = 1; i <= N; i++) {
                    if (graph[next][i] != 0) {
                        queue.add(i);
                        lenQueue.add(length + graph[next][i]);
                    }
                }
            }
        }
        return answer;
    }
}
