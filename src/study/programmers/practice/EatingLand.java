package study.programmers.practice;

import java.util.*;

public class EatingLand {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        }));
    }

    private static int solution(int[][] land) {
        int answer;
        int row = land.length;

        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < 4; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int k = 0; k < 4; k++) {
                    if (j != k) temp.add(land[i][k]);   // 이전 인덱스를 빼기 위해
                }
                land[i+1][j] += Collections.max(temp);  // 다음 최댓값 결정
            }
        }
        answer = Collections.max(List.of(land[row-1][0], land[row-1][1], land[row-1][2], land[row-1][3]));
        return answer;
    }
}
