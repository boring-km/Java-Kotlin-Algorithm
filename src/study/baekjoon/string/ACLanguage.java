package study.baekjoon.string;

import java.util.*;

public class ACLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String func = sc.next();
            int n = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            // 덱에 배열 원소를 넣어준다.
            for(int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean direction = true;
            for (int j = 0; j < func.length(); j++) {
                if (func.charAt(j) == 'R') {
                    direction = !direction;
                    continue;
                }
                if (direction) {
                    if (deque.pollFirst() == null) {
                        isError = true;
                        break;
                    }
                } else {
                    if (deque.pollLast() == null) {
                        isError = true;
                        break;
                    }
                }
            }
            if (isError) {
                answer.append("error\n");
            } else {
                answer.append("[");
                if (deque.size() > 0) {
                    if (direction) {
                        answer.append(deque.pollFirst());
                        while (!deque.isEmpty()) answer.append(",").append(deque.pollFirst());
                    } else {
                        answer.append(deque.pollLast());
                        while (!deque.isEmpty()) answer.append(",").append(deque.pollLast());
                    }
                }
                answer.append("]").append("\n");
            }
        }
        System.out.print(answer);
    }
}

/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRRRD
6
[1,1,2,3,5,8]
RRRRRD
0
[]
 */
