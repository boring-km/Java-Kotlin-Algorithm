package study.codility;

import java.util.Stack;

public class StackAndQueue_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> down = new Stack<>();
        int lastSize;
        int aliveCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) down.push(A[i]); // 내려가는 물고기는 스택에 추가
            else {
                while (!down.isEmpty()) {   // 내려가는 물고기가 없을 때까지
                    lastSize = down.peek(); // 마지막 내려가는 물고기 추가
                    if (lastSize > A[i]) break; // 만난 물고기가 더 작으면 잡아먹음
                    else down.pop();        // 만난 물고기가 더 크면 잡아먹힘
                }
                if (down.isEmpty()) aliveCount++;   // 내려가는 물고기가 없으면 생명 포인트 + 1 (내려가는 물고기를 잡고 살아난 물고기)
            }
        }
        return aliveCount + down.size();
    }
}
