package study.programmers.graph;

public class Friends4Blocks {
    public static void main(String[] args) {
        System.out.println(solution(7, 2,
                new String[]{
                        "AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"
                }));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] graph = new char[m][n];
        char[][] record = new char[m][n];

        // graph 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = board[i].charAt(j);
                record[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            boolean check = false;
            // 2x2가 같은 블록을 지운다.
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (graph[i][j] != ' ' &&
                            graph[i][j] == graph[i][j+1] &&
                            graph[i][j] == graph[i+1][j] &&
                            graph[i][j] == graph[i+1][j+1]) {
                        record[i][j] = ' ';
                        record[i][j+1] = ' ';
                        record[i+1][j] = ' ';
                        record[i+1][j+1] = ' ';
                        check = true;
                    }
                }
            }
            if (check) {
                // 아래 빈칸이 있으면 맨 밑이나 데이터가 있을 때까지 내린다.
                for (int y = 0; y < m - 1; y++) {
                    for (int x = 0; x < n; x++) {
                        char item = record[y][x];
                        if (item != ' ' && record[y+1][x] == ' ') {
                            int ry = y;
                            while (ry >= 0) {
                                item = record[ry][x];
                                int ty = ry + 1;
                                while (ty < m && record[ty][x] == ' ' && record[ty-1][x] != ' ') {
                                    record[ty-1][x] = ' ';
                                    record[ty][x] = item;
                                    ty++;
                                }
                                ry--;
                            }
                        }
                    }
                }
                // 지운 블록을 반영
                for (int i = 0; i < m; i++) {
                    if (n >= 0) System.arraycopy(record[i], 0, graph[i], 0, n);
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == ' ')
                    answer++;
            }
        }
        return answer;
    }
}
