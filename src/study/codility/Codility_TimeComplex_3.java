package study.codility;

public class Codility_TimeComplex_3 {
    // 100 %
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1000, 1000}));
    }
    public static int solution(int[] A) {
        int answer = 1000000;

        int first = 0;
        int second = 0;

        for(int sum : A){
            second += sum;
        }

        for (int j = 0, len = A.length; j < len - 1; j++) {
            first += A[j];
            second -= A[j];
            answer = Math.min(answer, Math.abs(second - first));
        }
        return answer;
    }
}
