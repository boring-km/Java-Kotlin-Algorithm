package study.programmers.practice;

public class CorrectBrace {
    public static void main(String[] args) {
        System.out.println(solution("(()("));
    }

    private static boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        int cur = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cur++;
            } else {
                if (cur == 0) return false;
                cur--;
            }
        }
        if (cur != 0) {
            return false;
        }

        return answer;
    }
}
