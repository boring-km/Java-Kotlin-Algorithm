package study.programmers.search;

import java.util.Arrays;

public class ImmigrationCheck {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{10, 20}));
    }

    public static long solution(int n, int[] times) {
        int size = times.length;
        Arrays.sort(times);
        long start = 1; // 첫번째에서 끝날 때
        long end = (long) times[size - 1] * n; // 가장 오래 걸리는 심사관에게 모든 인원이 심사를 받게되는 최대의 시간
        long answer = end;

        if (n <= size) {
            end = times[n-1];
            answer = end;
        }

        while (end - start >= 0) {
            long count = 0;
            long mid = (start + end) / 2;
            for (int time : times) {
                long temp = mid / time;
                count += temp;
            }
            if (count >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
