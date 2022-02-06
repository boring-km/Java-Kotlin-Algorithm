package study.programmers.string;

public class BrianWorry {
    public static void main(String[] args) {
        System.out.println(solution("aHbEbLbLbOacWdOdRdLdDc"));
    }

    public static String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        int size = sentence.length();

        StringBuilder word = new StringBuilder();
        char record = ' ';
        int rule = 0;
        for (int i = 0; i < size; i++) {
            int c = sentence.charAt(i);
            char temp = sentence.charAt(i);
            if (65 <= c && c <= 90) {
                // 대문자
                word.append(temp);
                if (i == size-1 && rule == 2) {
                    return "invalid";
                }
            } else {
                // 소문자 HaEaLaLaObWORLDb
                if (record == ' ') {
                    record = temp;
                    rule = 1;
                } else if (record == temp) {
                    // 붙어 있는 문자열
                } else {
                    // 이전과 다른 소문자가 들어옴
                    int check = sentence.charAt(i-1);
                    answer.append(word);
                    answer.append(' ');
                    if (65 <= check && check <= 90) {
                        // 대문자 다음에 다른 소문자가 온 경우
                        if (i > 1) {
                            check = sentence.charAt(i-2);
                            if (65 <= check && check <= 90) {   // 대문자 - 대문자 - 소문자
                                answer.deleteCharAt(answer.length()-1);
                                answer.deleteCharAt(answer.length()-1);
                                answer.append(' ');
                                answer.append(sentence.charAt(i-1));
                                rule = 1;
                            } else {    // 소문자 - 대문자 - 소문자
                                if (rule == 1) {
                                    rule = 2;   // 이전 대문자는 제외
                                } else {
                                    // 이전 대문자를 포함
                                    answer.deleteCharAt(answer.length()-1);
                                    answer.deleteCharAt(answer.length()-1);
                                    answer.append(' ');
                                    answer.append(sentence.charAt(i-1));
                                    rule = 1;
                                }
                            }
                        } else {
                            // 시작: 대문자 - 소문자
                            rule = 1;
                        }
                    } else {
                        // rule2 -> rule2
                        // 소문자 감싸기 다음에 소문자
                        rule = 2;
                    }
                    // 초기화
                    word = new StringBuilder();
                    record = temp;
                }
            }
        }
        answer.append(word);
        return answer.toString();
    }
}
