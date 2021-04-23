package study.programmers.string;

public class DartGame {

    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        String[] temp = dartResult.replaceAll("D", " D ")
                .replaceAll("S", " S ")
                .replaceAll("T", " T ")
                .replaceAll("\\*", "\\* ")
                .replaceAll("#", "# ")
                .split(" ");

        int cur = 0;
        int before = 0;
        for (String item : temp) {
            switch (item) {
                case "S":
                    break;
                case "D":
                    cur = cur * cur;
                    break;
                case "T":
                    cur = cur * cur * cur;
                    break;
                case "*":
                    answer += before;
                    before *= 2;
                    cur *= 2;
                    break;
                case "#":
                    cur *= -1;
                    break;
                default:
                    before = cur;
                    answer += cur;
                    cur = Integer.parseInt(item);
                    break;
            }
        }
        answer += cur;

        return answer;
    }
}
