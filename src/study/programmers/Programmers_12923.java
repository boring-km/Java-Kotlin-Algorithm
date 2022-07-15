package study.programmers;

public class Programmers_12923 {
    private static final int size = 10000000;
    private static int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin + 1)];

        // 100 ~ 10000 구간을 구한다면...

        for (long i = end; i >= begin; i--) {
            // 10000개의 i 중에 1 ~ 10000000 사이의 수를 약수로 가지는 수가 있는지 찾기
            answer[(int) (i - begin)] = (int) getDivisorAndFind(i);
        }

        return answer;
    }

    private static long getDivisorAndFind(long n) {
        if (n == 1) return 0;
        long sqrt = (long) Math.sqrt(n);
        long temp = 1;
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                // i
                if (i <= size && i != n) {
                    temp = Math.max(temp, i);
                }
                if (n / i != i) {
                    // n / i
                    if (i <= size && n / i != n) {
                        temp = Math.max(temp, n / i);
                    }
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] result = solution(1, 10);
        for (int item : result) {
            System.out.print(item + ",");
        }
    }
}
