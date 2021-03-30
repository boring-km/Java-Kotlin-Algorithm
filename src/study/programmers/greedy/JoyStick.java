package study.programmers.greedy;

public class JoyStick {
    public static void main(String[] args) {
        System.out.println(solution("AAZ"));
    }

    public static int solution(String name) {
        int answer = 0;

        int n = name.length();
        int skip_move = n - 1;

        for (int i = 0; i < n; i++) {
            int temp = ((int) name.charAt(i)) - 65;
            answer += Math.min(temp, 26 - temp);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // i + n - next: 왼쪽으로 돌아가면서 A가 아닌 것을 만날 때까지 이동한 횟수
            // Math.min(i, n-next): 현재 인덱스와 뒤에서 가장 가까운 A가 아닌 인덱스 중 작은 값
            skip_move = Math.min(skip_move, i + n - next + Math.min(i, n-next));
        }
        answer += skip_move;
        return answer;
    }
}

// abcde fghij klmno pqrst uvwxy z
