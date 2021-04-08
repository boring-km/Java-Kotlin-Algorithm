package study.programmers.practice;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] result = solution(new int[][]{
                {1, 4}, {3, 2}, {4, 1}
        }, new int[][]{
                {3, 3}, {3, 3}
        });
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        // 1 4
        // 3 2    3 3
        // 4 1    3 3
        int n1 = arr1.length;
        int n2 = arr1[0].length;
        int m = arr2[0].length;
        int[][] answer = new int[n1][m];
        for (int i = 0; i < n1; i++) {   // 왼쪽 행렬의 행
            int cur = 0;
            for (int k = 0; k < m; k++) {
                for (int j = 0; j < n2; j++) {
                    int temp = arr1[i][j] * arr2[j][k];
                    cur += temp;
                }
                answer[i][k] = cur;
                cur = 0;
            }
        }

        return answer;
    }
}
