package study.programmers;

import java.util.LinkedList;
import java.util.Queue;

// 59분 22초
public class Programmers_42583 {

    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer;

        Queue<Integer> truck_wait_queue = new LinkedList<>();
        Queue<int[]> truck_going_queue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            truck_wait_queue.offer(truck_weight);
        }
        int current_truck_weights = 0;
        int time = 0;

        while (true) {
            time++;
            if (!truck_going_queue.isEmpty()) {
                int[] truck = truck_going_queue.peek();
                if (time - truck[0] == bridge_length) {
                    truck_going_queue.poll();
                    current_truck_weights -= truck[1];
                }
            }

            Integer next_truck_weight = truck_wait_queue.peek();
            if (truck_wait_queue.isEmpty()) {
                if (truck_going_queue.isEmpty()) {
                    answer = time;
                    break;
                }
                continue;
            }

            if (current_truck_weights + next_truck_weight <= weight) {
                int truck_weight = truck_wait_queue.poll();
                current_truck_weights += truck_weight;
                truck_going_queue.offer(new int[]{time, truck_weight});
            }
        }

        return answer;
    }
}