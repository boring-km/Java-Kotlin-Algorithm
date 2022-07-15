package study.programmers;

public class Programmers_12923 {
    private static final int size = 10000000;
    private static int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin + 1)];

        // 100 ~ 10000 구간을 구한다면...

        for (long i = begin; i <= end ; i++) {
            // 10000개의 i 중에 1 ~ 10000000 사이의 수를 약수로 가지는 수가 있는지 찾기
            answer[(int) (i - begin)] = getDivisorAndFind(i);
        }

        return answer;
    }

    private static int getDivisorAndFind(long n) {
        if (n == 1) return 0;
        long sqrt = (int) Math.sqrt(n);
        long temp = 1;
        for (long i = 2; i <= sqrt; i++) {
            long mok = n / i;
            if (mok > size) continue;
            if (n % i == 0) {
                temp = mok;
                break;
            }
        }
        return (int) temp;
    }

    public static void main(String[] args) {
        int[] result = solution(1000000000 - 100, 1000000000);
        for (int item : result) {
            System.out.print(item + ",");
        }
    }
}
