package study.programmers;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12902
public class Programmers_12902 {

    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(22));
    }

    private static int solution(int n) {

        List<Long> list = new ArrayList<>(List.of(0L, 3L, 11L));

        // 0, 3, 3 * 3 + 2
        // f(6) = f(4) * 3 + f(2) * 2 + 2
        // f(8) = f(6) * 3 + f(4) * 2 + f(2) * 2 + 2
        // f(10) = f(8) * 3 + f(6) * 2 + f(4) * 2 + f(2) + 2

        int index = n / 2;
        for (int i = 3; i <= index; i++) {
            long sum = list.subList(1, i-1).stream().mapToLong(Long::longValue).sum() * 2 + 2;
            list.add((list.get(i-1) * 3 + sum) % 1000000007);
        }

        return list.get(index).intValue();
    }
}
