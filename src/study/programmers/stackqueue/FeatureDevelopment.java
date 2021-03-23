package study.programmers.stackqueue;

import java.util.*;

public class FeatureDevelopment {

    public static void main(String[] args) {
        int[] result = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int n = progresses.length;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                progresses[i] += speeds[i];
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                if (progresses[i] >= 100 && !queue.isEmpty()) {
                    if (queue.peek() == i) {
                        queue.poll();
                        count++;
                        for (int j = i; j < n; j++) {
                            if (progresses[j] >= 100 && !queue.isEmpty()) {
                                if (queue.peek() == j) {
                                    queue.poll();
                                    count++;
                                }
                            } else {
                                break;
                            }
                        }
                        list.add(count);
                    }
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
