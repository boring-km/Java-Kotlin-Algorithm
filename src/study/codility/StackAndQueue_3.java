package study.codility;

import java.util.Stack;

public class StackAndQueue_3 {
    public static void main(String[] args) {
        System.out.println(solution("()()()"));
    }

    public static int solution(String S) {
        char[] array = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0, len = array.length; i < len; i++) {
            if (array[i] == ')') {
                if (stack.size() == 0) {
                    return 0;
                }
                stack.pop();
            } else {
                stack.add('(');
            }
        }
        if (stack.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
