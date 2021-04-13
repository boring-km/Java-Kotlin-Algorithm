package study.programmers.practice;

import java.util.Arrays;

public class LowestCommonMultiple {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }

    public static int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int size = arr.length;
        int max = arr[size-1];
        int cur = max;
        while (true) {
            int count = 0;
            for (int i = 0; i < size-1; i++) {
                if (cur % arr[i] == 0) count++;
            }
            if (count == size-1) {
                answer += cur;
                break;
            }
            cur += max;
        }

        return answer;
    }
}
