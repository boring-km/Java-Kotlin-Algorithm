package study.programmers.practice;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumAndMinimum {
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }

    public static String solution(String s) {
        ArrayList<Long> list = new ArrayList<>();
        String[] stringArray = s.split(" ");

        for (String numStr : stringArray) {
            list.add(Long.parseLong(numStr));
        }
        long mini = list.stream().min(Comparator.naturalOrder()).get();
        long maxi = list.stream().max(Comparator.naturalOrder()).get();

        return mini + " " + maxi;
    }
}
