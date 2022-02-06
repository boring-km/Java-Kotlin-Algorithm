package study.programmers.string;

public class NumberAndEnglishWords {
    public static void main(String[] args) {
        solution("");
    }

    public static int solution(String s) {
        int answer = 0;

        String result = s.replaceAll("zero", "0")
                .replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9");

        answer += Integer.parseInt(result);

        return answer;
    }
}
