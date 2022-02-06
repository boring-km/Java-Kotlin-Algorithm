package study.programmers.practice;

public class Triangle {
    public static void main(String[] args) {
        solution(6);
    }

    public static int[] solution(int n) {
        int size = n*(n+1) / 2;
        int[] answer = new int[size];
        int depth = 0;
        int width = 0;

        for (int i = 1; i <= size; i++) {
            answer[depth + width] = i;
        }

        return answer;
    }
}
