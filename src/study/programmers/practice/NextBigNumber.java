package study.programmers.practice;

public class NextBigNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int answer;
        int count = getData(n);
        while (true) {
            n++;
            int new_count = getData(n);
            if (count == new_count) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    private static int getData(int n) {
        String binary = Integer.toBinaryString(n);
        int size = binary.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if ('1' == binary.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
