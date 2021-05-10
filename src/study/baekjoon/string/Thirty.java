package study.baekjoon.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다.
 미르코는 30이란 수를 존경하기 때문에,
 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.

미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
 */

public class Thirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int sum = 0;
        boolean isHaveZero = false;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            // 3 조건
            int number = ((int) target.charAt(i)) - 48;
            sum += number;
            list.add(number);
            // 2, 5 조건
            if (number == 0) isHaveZero = true;
        }
        if (isHaveZero && sum % 3 == 0) {
            list.sort(Comparator.reverseOrder());
            list.forEach(System.out::print);
        } else {
            System.out.println(-1);
        }
    }
}
