package study.codility;

public class StackAndQueue_1 {
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
    }

    public static int solution(String S) {
        char[] array = S.toCharArray();
        int length = array.length;
        if (S.length() == 0) {
            return 1;
        }
        char curChar = array[0];
        int a = 0, b = 0, c = 0;
        if (curChar == '}' || curChar == ']' || curChar == ')') {
            return 0;
        }
        if (curChar == '(') {
            a += 1;
        } else if (curChar == '{') {
            b += 1;
        } else {
            c += 1;
        }
        for (int i = 1; i < length; i++) {
            if (curChar == '{' && (array[i] == ']' || array[i] == ')')) {
                return 0;
            }
            if (curChar == '[' && (array[i] == ')' || array[i] == '}')) {
                return 0;
            }
            if (curChar == '(' && (array[i] == '}' || array[i] == ']')) {
                return 0;
            }
            curChar = array[i];
            if (curChar == '(') {
                a += 1;
            } else if (curChar == '{') {
                b += 1;
            } else if (curChar == '[') {
                c += 1;
            } else if (curChar == ')') {
                a -= 1;
            } else if (curChar == '}') {
                b -= 1;
            } else if (curChar == ']') {
                c -= 1;
            }
            if (a < 0 || b < 0 || c < 0) {
                return 0;
            }
        }
        if (a == 0 && b == 0 && c == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
