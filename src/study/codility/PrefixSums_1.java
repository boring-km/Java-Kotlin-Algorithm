package study.codility;

public class PrefixSums_1 {
    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
    }

    public static int solution(int A, int B, int K) {
        // TODO A부터 B까지 2로 나뉘는 수의 갯수를 구하자
        if (A == 0) {
            return B/K + 1;
        } else {
            return B/K - (A-1)/K;
        }
    }
}
