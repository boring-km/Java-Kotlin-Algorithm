package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NewEmployee {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] array = new int[n][2];
            int result = 0;
            for (int j = 0; j < n; j++) {
                // 서류심사 성적, 면접 성적 순위
                String[] temp = bf.readLine().split(" ");
                array[j][0] = Integer.parseInt(temp[0]);
                array[j][1] = Integer.parseInt(temp[1]);
            }
            Arrays.sort(array, Comparator.comparingInt(o -> o[0]));

            int temp = -1;
            for (int j = 0; j < n; j++) {
                if (temp == -1) {
                    temp = array[j][1];
                    ++result;
                } else {
                    if (array[j][1] < temp) {
                        ++result;
                        temp = array[j][1];
                    }
                }
            }
            System.out.println(result);
        }
        bf.close();
    }
}
