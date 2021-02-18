package study.codility;

public class Codility_TimeComplex_1 {
    public static void main(String[] args) {
        int result = solution(15, 70, 10);
        System.out.println(result);
    }

    public static int solution(int X, int Y, int D) {
        int count = 0;
        int currentNumber = X;

        while (true) {
            if (currentNumber >= Y) {
                break;
            }
            count++;
            currentNumber += D;
        }

        return count;
    }
}
