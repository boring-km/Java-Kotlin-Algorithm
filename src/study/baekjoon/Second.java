package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Second {
    //static int[] dx = new int[]{}
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            System.out.print(bfs(start, end));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int bfs(int start, int end) {

        int cur = start;
        int[] arr = new int[100001];
        boolean[] check = new boolean[100001];
        check[start] = true;
        Queue<Integer> qx = new LinkedList<>();
        qx.add(cur);

        while (!qx.isEmpty()) {
            cur = qx.poll();
            //System.out.println("cur: " + cur + " count: " + arr[cur]);
            if (cur == end) {
                break;
            }

            if (cur * 2 < 100001 && cur * 2 >= 0){
                if (!check[cur*2] && arr[cur * 2] == 0) {
                    qx.add(cur * 2);
                    arr[cur * 2] += arr[cur] + 1;
                }
            }
            if (cur + 1 < 100001 && cur + 1 >= 0) {
                if (!check[cur+1] && arr[cur + 1] == 0) {
                    qx.add(cur + 1);
                    arr[cur + 1] += arr[cur] + 1;
                }
            }
            if (cur - 1 >= 0) {
                if (!check[cur - 1] && arr[cur - 1] == 0) {
                    qx.add(cur - 1);
                    arr[cur - 1] += arr[cur] + 1;
                }
            }
        }
        return arr[end];
    }
}
