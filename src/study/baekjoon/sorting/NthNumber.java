package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class NthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] data = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(data[i]));
        }
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
