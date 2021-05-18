package study.baekjoon.binarysearch;

import java.util.Scanner;

// 1072번
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        long z = y * 100 / x;
        long start = 0;
        long end = x+1;
        long answer = -1;

        while (end - start >= 0) {
            long mid = (end + start) / 2;
            long tz = (y+mid)*100 / (x+mid);
            if (tz > z) {
                if (answer == -1) {
                    answer = mid;
                } else {
                    answer = Math.min(answer, mid);
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
