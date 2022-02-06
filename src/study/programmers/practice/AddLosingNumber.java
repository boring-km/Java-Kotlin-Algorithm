package study.programmers.practice;

public class AddLosingNumber {
    public static void main(String[] args) {
        int result = solution(new int[]{1,2,3,4,6,7,8,0});
        System.out.println(result);
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        int[] check = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            check[numbers[i]] += 1;
        }

        for (int i = 0; i < 10; i++) {
            if (check[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
