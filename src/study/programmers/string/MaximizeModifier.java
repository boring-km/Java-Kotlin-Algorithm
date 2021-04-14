package study.programmers.string;

// 1시간 40분
public class MaximizeModifier {
    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

    public static long solution(String expression) {
        long answer = 0;
        String[] replaced = replaceExpression(expression);
        StringBuilder cur = new StringBuilder();
        String[][] allCases = new String[][]{   // 연산자 3개를 사용하는 모든 경우
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"*", "+", "-"},
                {"*", "-", "+"},
                {"-", "+", "*"},
                {"-", "*", "+"}
        };
        for (String[] array: allCases) {
            for (String oper: array) {
                String before = "";
                String operator = "";
                for (String item : replaced) {
                    if (item.equals(oper)) {
                        operator = item;
                        int minusSize = before.length();
                        cur = new StringBuilder(cur.substring(0, cur.length() - minusSize));
                    } else if (!Character.isDigit(item.charAt(0)) && item.length() == 1) {
                        cur.append(" ").append(item).append(" ");
                        before = "";
                    } else {
                        if (operator.equals(oper)) {    // 연산자에 따라 다른 계산을 수행
                            long tempnum;
                            if (oper.equals("-")) {
                                tempnum = Long.parseLong(before) - Long.parseLong(item);
                            } else if (oper.equals("+")) {
                                tempnum = Long.parseLong(before) + Long.parseLong(item);
                            } else {
                                tempnum = Long.parseLong(before) * Long.parseLong(item);
                            }
                            String temp = String.valueOf(tempnum);

                            cur.append(temp);
                            operator = "";
                            before = temp;
                        } else {
                            before = item;
                            cur.append(item);
                        }
                    }
                }
                replaced = cur.toString().split(" ");
                cur = new StringBuilder();
            }
            if (replaced.length == 1) {
                answer = Math.max(Math.abs(answer), Math.abs(Long.parseLong(replaced[0])));
            }
            replaced = replaceExpression(expression);
        }
        return answer;
    }

    private static String[] replaceExpression(String expression) {
        return expression.replaceAll("\\+", " + ")
                .replaceAll("-", " - ")
                .replaceAll("\\*", " * ").split(" ");
    }
}
