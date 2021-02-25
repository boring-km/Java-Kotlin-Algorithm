package study.programmers;

// 10분 정도
public class Search_42842 {
    public static void main(String[] args) {
        int[] result = solution(24, 24);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        // 노랑 N * M = 24
        // 갈색 (N+2) * (M+2) = 24 + 24
        // NM = 24
        // NM + 2N + 2M + 4 = 48
        // N + M = 10
        // N >= M

        // N + M
        int fullCount = (brown - 4) / 2;
        for (int n = fullCount-1; n > 0; n--) {
            int m = fullCount - n;
            if (n * m == yellow) {
                answer = new int[]{n+2, m+2};
                break;
            }
        }

        return answer;
    }
}
