package study.programmers.practice;

// 풀이시간 32분
public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;
        int[][] move = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        }; // R, L, U, D
        int[] cur = new int[]{0, 0};
        int length = dirs.length();
        int[][] visited = new int[length][4];
        for (int i = 0; i < length; i++) {
            int j;
            if (dirs.charAt(i) == 'R') {
                j = 0;
            } else if (dirs.charAt(i) == 'L') {
                j = 1;
            } else if (dirs.charAt(i) == 'U') {
                j = 2;
            } else {
                j = 3;
            }
            if (cur[0] + move[j][0] < -5 ||
                    cur[0] + move[j][0] > 5 ||
                    cur[1] + move[j][1] < -5 ||
                    cur[1] + move[j][1] > 5) {
                continue;
            }
            boolean check = true;
            for (int k = 0; k < i; k++) {
                if ((visited[k][0] == cur[0] && visited[k][1] == cur[1] && visited[k][2] == cur[0] + move[j][0] && visited[k][3] == cur[1] + move[j][1]) ||
                        (visited[k][0] == cur[0] + move[j][0] && visited[k][1] == cur[1] + move[j][1] && visited[k][2] == cur[0] && visited[k][3] == cur[1])) {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
            visited[i][0] = cur[0];
            visited[i][1] = cur[1];
            cur[0] += move[j][0];
            cur[1] += move[j][1];
            visited[i][2] = cur[0];
            visited[i][3] = cur[1];
        }
        return answer;
    }
}
