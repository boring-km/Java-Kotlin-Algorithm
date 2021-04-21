package study.programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        int[] result = solution(new String[]{
                "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
        });
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] temp = operation.split(" ");
            String command = temp[0];
            int num = Integer.parseInt(temp[1]);
            if (command.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else {
                if (minHeap.size() == 0)
                    continue;
                if (num < 0) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                } else {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }
            }
        }
        if (minHeap.size() == 0) {
            answer = new int[]{0, 0};
        } else {
            int min = minHeap.poll();
            int max = maxHeap.poll();
            answer = new int[]{max, min};
        }

        return answer;
    }
}
