package study.codility;

public class CountingElement_1 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
    }

    public static int solution(int X, int[] A) {
        int answer = -1;
        boolean[] leafArray = new boolean[X+1];
        int sum = (1+X)*X / 2;

        for (int i = 0, len = A.length; i < len; i++) {
            if (!leafArray[A[i]]) {
                sum -= A[i];
                leafArray[A[i]] = true;
            }
            if (sum == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
