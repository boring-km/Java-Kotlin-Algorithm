package study.programmers;

import java.util.ArrayList;

public class Programmers_12936 {

    private static int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>(); // {1, 2, 3, 4, ... }
        long cur = 1;    // n!로 초기화
        for (int i = 1; i <= n; i++) {
            cur *= i;
            list.add(i);
        }
        k--;    // 목적지 -= 1

        int index = 0;
        // 어떻게 이런 생각을... 나는 아직 멀었다.
        while (index < answer.length) {
            cur /= n--;   // n!에서(cur에서) n 하나씩 나눠 보기
            int target = (int) (k / cur);
            answer[index++] = list.get(target);  // 현재 위치의 값 찾기
            // cur값이 아직 너무 크면 0이 나와서 맨 앞자리부터 숫자 채움
            list.remove(target); // 사용한 숫자는 리스트에서 제거
            k %= cur;   // (n-m)!로 나눈 나머지 값만 생각
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] result1 = solution(4, 17);
        for (int i : result1) {
            System.out.print(i + ", ");
        }
        System.out.println();
        int[] result2 = solution(12, 170);
        for (int i : result2) {
            System.out.print(i + ", ");
        }
    }
}
