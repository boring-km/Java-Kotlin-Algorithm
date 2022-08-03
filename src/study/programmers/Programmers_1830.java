package study.programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_1830 {

    // 규칙 1: 한 단어의 사이사이마다 같은 소문자 넣기
    // 규칙 2: 한 단어의 양 끝에 같은 소문자 넣기
    private static String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        int size = sentence.length();
        boolean wasBig = false;

        int start1 = -1;
        int end1;
        int start2 = -1;
        int end2;
        char rule1 = ' ';
        char rule2 = ' ';

        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int c = sentence.charAt(i);

            // 대문자
            if (65 <= c && c <= 90) {
                if (wasBig) {
                    if (rule1 != ' ') {
                        end1 = i;
                        if (!map.containsKey(rule1)) {
                            map.put(rule1, true);
                        } else return "invalid";
                        answer.append(sentence.substring(start1, end1).replaceAll(String.valueOf(rule1), ""));
                        rule1 = ' ';
                    }
                }
                wasBig = true;
            }
            // 소문자
            else {
                if (!wasBig) {
                    // 앞에 소문자였거나 없거나 아무튼 규칙 2
                    rule2 = (char) c;
                    start2 = i;
                } else {
                    if (rule2 != ' ') {
                        // 규칙 2 종료
                        if (rule2 == (char) c) {
                            end2 = i;
                            if (start2 != 0) answer.append(" ");
                            if (!map.containsKey(rule2)) {
                                map.put(rule2, true);
                            } else return "invalid";
                            answer.append(sentence, start2 + 1, end2);
                            rule2 = ' ';
                        }
                    } else {
                        // 규칙 2가 적용이 안되고 있더라면 규칙 1이 되어야지
                        if (rule1 == ' ') { // 적용 전이라면
                            rule1 = (char) c;
                            start1 = i - 1;
                        } else if (rule1 != (char) c) {
                            end1 = i;
                            if (!map.containsKey(rule1)) {
                                map.put(rule1, true);
                            } else return "invalid";
                            if (start1 != 0) answer.append(" ");
                            answer.append(sentence.substring(start1, end1).replaceAll(String.valueOf(rule1), ""));
                            rule1 = ' ';
                            // 앞에가 규칙 1로 끝났다면 규칙 2 시작
                            rule2 = (char) c;
                            start2 = i;
                        }
                    }
                }
                wasBig = false;
            }
        }
        if (rule1 != ' ') {
            end1 = size;
            if (!map.containsKey(rule1)) {
                map.put(rule1, true);
            } else return "invalid";
            if (start1 != 0) answer.append(" ");
            answer.append(sentence.substring(start1, end1).replaceAll(String.valueOf(rule1), ""));
        }
        if (rule2 != ' ') {
            return "invalid";
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String result = solution("HaEaLaLaObWORLDb");
        System.out.println(result);
    }
}
