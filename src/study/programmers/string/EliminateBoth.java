package study.programmers.string;

// 결과가 효율성 테스트에서 시간 초과 나옴
public class EliminateBoth {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
    public static int solution(String s)
    {
        int answer = 0;

        while (true) {
            int size = s.length();
            StringBuilder record = new StringBuilder();
            char before = ' ';
            for (int i = 0; i < size; i++) {
                if (before == s.charAt(i)) {
                    record = new StringBuilder(record.substring(0, record.length() - 1));
                    before = ' ';
                    continue;
                }
                before = s.charAt(i);
                record.append(s.charAt(i));
            }
            if (record.toString().length() == 0) {
                answer = 1;
                break;
            }
            if (record.toString().length() == size) {
                break;
            }
            s = record.toString();
        }

        return answer;
    }
}
