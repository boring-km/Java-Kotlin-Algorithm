package study.programmers.practice;

public class AddSubMultiples {
    public static void main(String[] args) {
        int result = solution(12, 12);
        System.out.println(result);
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int j = 1; j <= i; j += 1) {
                if (i % j == 0) count++;
            }
            if (count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }
}
