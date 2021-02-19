package study.codility;

import java.util.Stack;

public class Leader_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1}));
    }

    // https://myung6024.tistory.com/55
    public static int solution(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || stack.peek() == A[i]) {
                stack.push(A[i]);
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        int num = stack.pop();
        int[] B = new int[A.length];
        int ncnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == num) {
                ncnt += 1;
            }
            B[i] = ncnt;
        }
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (B[i - 1] >= i / 2 + 1 && B[A.length - 1] - B[i - 1] >= (A.length - i) / 2 + 1) {
                ans++;
            }
        }
        return ans;

    }
}
