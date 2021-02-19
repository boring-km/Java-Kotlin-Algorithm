package study.codility;

import java.util.Stack;

public class StackAndQueue_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    public static int solution(int[] A, int[] B) {
        int N = A.length;
        Stack<Integer> upStack = new Stack<>();
        Stack<Integer> downStack = new Stack<>();
        int lastStream = B[0];
        if (lastStream == 0) {
            upStack.add(A[0]);
        } else {
            downStack.add(A[0]);
        }

        for (int i = 1; i < N; i++) {
            if (B[i] == 0) {
                upStack.add(A[i]);
                if (lastStream == 1) {
                    int lastFish = downStack.peek();
                    if (lastFish < A[i]) {
                        downStack.pop();
                        lastStream = 0;
                    }
                    if (lastFish > A[i]) {
                        upStack.pop();
                        lastStream = 1;
                    }
                }
            } else {
                downStack.add(A[i]);
                lastStream = 1;
            }
        }

        return upStack.size() + downStack.size();
    }
}
