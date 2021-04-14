package study.programmers.string;

import java.util.ArrayList;
import java.util.Stack;

// 결과가 효율성 테스트에서 시간 초과 나옴
public class EliminateBoth {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
    public static int solution(String s)
    {
        int answer;
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            stack.add(s.charAt(i));
        }
        ArrayList<Character> cur = new ArrayList<>();
        while (!stack.isEmpty()) {
            if (cur.size() == 0) {
                cur.add(stack.pop());
                continue;
            }
            if (cur.get(cur.size()-1) == stack.get(stack.size()-1)) {
                cur.remove(cur.size()-1);
                stack.pop();
                continue;
            }
            cur.add(stack.pop());
        }
        int size = cur.size();
        if (size == 0) answer = 1;
        else answer = 0;
        return answer;
    }
}
