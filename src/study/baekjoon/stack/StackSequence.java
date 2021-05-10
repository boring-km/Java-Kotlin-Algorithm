package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        StringBuilder result = new StringBuilder();
        result.append("+\n");
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            while (true) {
                if (stack.isEmpty() && cur < target) {
                    stack.add(++cur);
                    result.append("+\n");
                } else if (stack.peek() < target) {
                    stack.add(++cur);
                    result.append("+\n");
                } else if (stack.peek() == target) {
                    stack.pop();
                    result.append("-\n");
                    break;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(result);
    }
}
