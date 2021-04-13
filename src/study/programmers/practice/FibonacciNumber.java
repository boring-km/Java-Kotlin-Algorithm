package study.programmers.practice;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static long solution(int n) {
        long first = 0;
        long second = 1;
        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = (first + second) % 1234567;
            first = second;
            second = result;
        }
        return result % 1234567;
    }
}
