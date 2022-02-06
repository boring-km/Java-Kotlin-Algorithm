package study.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class CaveAdventure {
    public static void main(String[] args) {
        System.out.println(solution(
                9,
                new int[][]{{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
                new int[][]{{8, 5}, {6, 7}, {4, 1}}
        ));
    }

    public static boolean solution(int n, int[][] path, int[][] order) {
        int[] before = new int[n];
        int[] after = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        ArrayList<Integer> data[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            data[i] = new ArrayList<>();
        }
        for (int[] fromTo : path) { // 쌍방향 경로 연결
            data[fromTo[0]].add(fromTo[1]);
            data[fromTo[1]].add(fromTo[0]);
        }
        for (int[] item : order) {
            before[item[1]] = item[0];  // to -> from
        }

        // order의 목적지에 루트 노드(0)를 넣게 되면 x -> 0으로 가는 경로가 먼저가 될 수 없다. (0에서 시작하니까)
        if (before[0] != 0) return false;

        Stack<Integer> stack = new Stack<>();
        stack.addAll(data[0]); // 0과 연결된 경로 모두 stack에 추가

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!visited[cur]) {    // 방문한 적이 없는 노드
                if (!visited[before[cur]]) {    // order에 있는 값이면 before[cur]가 0이 아니다.
                    after[before[cur]] = cur;   // 이전 노드의 다음 노드로 cur 추가 (먼저 탐색)
                    continue;
                }
                visited[cur] = true;    // order에 없으면 방문
                stack.addAll(data[cur]);    // 연결된 모든 노드 추가
                stack.add(after[cur]);  // 다음 노드에도 추가
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 모든 방을 방문하지 않았다면 false
                return false;
            }
        }

        return true;
    }
}
