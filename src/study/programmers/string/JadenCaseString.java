package study.programmers.string;

public class JadenCaseString {
    public static void main(String[] args) {
        System.out.println(solution(" a b c d e f "));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean check = false;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!check) {
                answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                if (s.charAt(i) != ' ') check = true;
            } else {
                if (s.charAt(i) == ' ') check = false;
                answer.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }

        return answer.toString();
    }
}
