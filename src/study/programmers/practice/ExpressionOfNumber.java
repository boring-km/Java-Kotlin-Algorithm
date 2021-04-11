package study.programmers.practice;

public class ExpressionOfNumber {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        int mid = n / 2 + 1;
        int start = 1;
        int next = 1;
        int cur = 0;
        int count = 0;

        while (true) {

            if (count == 1 && cur >= n) {
                if (cur == n) answer++;
                break;
            }
            if (cur >= n) {
                if (cur == n) {
                    answer++;
                }
                start++;
                next = start;
                cur = 0;
                count = 0;
            }

            count++;
            cur += next;
            next++;
        }

        return answer;
    }
}
