package study.programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

// 1시간 10분 초과.. 포기
// https://leveloper.tistory.com/36
public class Greedy_42884 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        int answer = 0; // 카메라의 갯수
        int camera = -30001; // 카메라의 위치
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));    // 나간 지점을 기준으로 정렬
        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }

}
