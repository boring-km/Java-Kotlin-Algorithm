package study.programmers.string;

public class BinaryConversionRepeat {
    public static void main(String[] args) {
        int[] result = solution("110010101001");
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(String s) {

        int count = 1;
        int removed = 0;

        while (true) {
            int before = s.length();
            s = s.replaceAll("0", "");
            int after = s.length();
            removed += before - after;
            if (after == 1) break;
            // after의 길이를 값으로 가지는 이진수
            s = Integer.toBinaryString(after);
            count++;
        }

        return new int[]{count, removed};
    }
}
