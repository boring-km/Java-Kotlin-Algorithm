package study.codility;

import java.util.Stack;

public class StackAndQueue_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }
    public static int solution(int[] H) {
        int N = H.length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= H[i]) {
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < H[i]) {
                answer++;
                stack.add(H[i]);
            }
        }
        return answer;
    }
}
