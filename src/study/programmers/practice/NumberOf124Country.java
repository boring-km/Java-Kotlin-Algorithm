package study.programmers.practice;

public class NumberOf124Country {
    public static void main(String[] args) {
        System.out.println(solution(20));
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int addNum;
        while (n != 0) {
            if (n % 3 == 0) {
                addNum = 4;
            } else {
                addNum = n % 3;
            }
            answer.insert(0, addNum);
            if (addNum == 4) {
                n = n/3 - 1;
            } else {
                n = n/3;
            }
        }
        return answer.toString();
    }
}
