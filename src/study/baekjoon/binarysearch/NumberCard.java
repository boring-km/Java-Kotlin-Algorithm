package study.baekjoon.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        int m = sc.nextInt();
        System.out.print(binarySearch(data, sc.nextInt()));
        for (int i = 1; i < m; i++) {
            System.out.print(" " + binarySearch(data, sc.nextInt()));
        }
    }

    private static int binarySearch(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        while (end - start >= 0) {
            int mid = (start + end) / 2;
            if (data[mid] == target) {
                return 1;
            } else if (data[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
