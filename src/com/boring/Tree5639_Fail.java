package com.boring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Tree5639_Fail {
    private static final int MAX = 10001;
    private static final int[][] preorder = new int[MAX][2];

    public static void main(String[] args) {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final Stack<Integer> stack = new Stack<>();
        int num;
        int root = 0;
        int last_v = 0;
        String t;
        try {
            while ((t = br.readLine())!=null) {
                num = toint(t);
                if (stack.empty()) {
                    stack.push(num);
                    root = num;
                } else {
                    int temp_num = stack.pop();
                    if (num < temp_num) {
                        stack.push(temp_num);
                        stack.push(num);
                        preorder[temp_num][0] = num;
                    } else {
                        while (true) {
                            if (num > temp_num) {
                                last_v = temp_num;
                                if (temp_num == root) {
                                    stack.push(root);
                                    stack.push(num);
                                    preorder[root][1] = num;
                                }
                                temp_num = stack.pop();
                            } else {
                                stack.push(temp_num);
                                preorder[last_v][1] = num;
                                break;
                            }
                        }
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        postorder(preorder, root);
    }

    private static void postorder(int[][] array, int value) {
        if (value == 0) {
            return;
        }
        postorder(array, array[value][0]);
        postorder(array, array[value][1]);
        System.out.println(value);
    }

    private static int toint(String s) {
        return Integer.parseInt(s);
    }
}
