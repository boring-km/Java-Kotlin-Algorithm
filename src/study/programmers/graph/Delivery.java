package study.programmers.graph;

import java.util.*;

// 1시간 20분 -> 시간초과 (정확성 81.3%)
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
        final int MAX = 1000000;
        int answer = 0;

        int[][] adj = new int[N][N];
        for (var a : adj) {
            Arrays.fill(a, MAX);
        }

        for (int[] a : road) {
            int x = a[0]-1;
            int y = a[1]-1;
            int w = a[2];
            if (w < adj[x][y]) {
                adj[x][y] = adj[y][x] = w;
            }
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, MAX);
        // 우선순위 큐 - Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));

        dist[0] = 0;
        pq.add(0);

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if (visited[curr]) continue;

            visited[curr] = true;
            for (int i = 0; i < N; i++) {
                if (adj[curr][i] == MAX) continue;

                if (dist[i] > dist[curr] + adj[curr][i]) {
                    dist[i] = dist[curr] + adj[curr][i];
                    pq.offer(i);
                }
            }
        }

        for (var a : dist) {
            if (a <= K) answer++;
        }

        return answer;
    }
}
