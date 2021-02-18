package study.codility;

public class Codility_TimeComplex_2 {
    public static void main(String[] args) {
        int result = solution(new int[]{2, 3, 1, 5});
        System.out.println(result);
    }

    public static int solution(int[] A) {
        int len = A.length;
        boolean[] checkArray = new boolean[len+2];
        int answer = 0;
        for (int j : A) {
            checkArray[j] = true;
        }
        for (int j = 1; j <= len+1; j++) {
            if (!checkArray[j]) {
                answer = j;
                break;
            }
        }
        return answer;
    }
}
