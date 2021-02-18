package study.codility;

public class CountingElement_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 1, 3}));
    }

    public static int solution(int[] A) {
        boolean[] check = new boolean[100002];

        for (int i = 0, len = A.length; i < len; i++) {
            if (A[i] <= 100000) {
                if (check[A[i]]) {
                    return 0;
                }
                check[A[i]] = true;
            }
        }

        int checkCount = 1;
        for (int i = 1, len = check.length; i < len; i++) {
            if (check[i]) {
                checkCount++;
            } else {
                if (checkCount != i) {
                    return 0;
                }
                if (i == A.length + 1) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
