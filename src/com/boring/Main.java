package com.boring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //static int[] dz = {};
    public static int n, m, d;
    public static int map[][][];
    public static boolean visit[][][];
    public static int count = 0;
    public static int minus = 0;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {

        map = new int[100][100][100];
        visit = new boolean[100][100][100];
        ArrayList<Integer> x_tmp = new ArrayList<Integer>();
        ArrayList<Integer> y_tmp = new ArrayList<Integer>();
        ArrayList<Integer> z_tmp = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            d = Integer.parseInt(input[2]);
            for (int k = 0; k < d; k++) {
                for (int i = 0; i < m; i++) {
                    String[] temp = br.readLine().split(" ");
                    for (int j = 0; j < n; j++) {

                        map[i][j][k] = Integer.parseInt(temp[j]);
                        if (map[i][j][k] == 1) {
                            x_tmp.add(j);
                            y_tmp.add(i);
                            z_tmp.add(k);
                        } else if (map[i][j][k] == -1) {
                            ++minus;
                        }
                    }
                }
            }
            System.out.println(bfs(x_tmp, y_tmp, z_tmp));

        } catch (IOException e) {
        }
    }

    public static int bfs(ArrayList<Integer> x_list, ArrayList<Integer> y_list, ArrayList<Integer> z_list) {
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        Queue<Integer> qz = new LinkedList<Integer>();
        boolean flag = false;
        int temp_size = x_list.size();
        // x = 5, y = 3, z = 2
        int error = 0;
        for (int i = 0; i < x_list.size(); i++) {
            visit[y_list.get(i)][x_list.get(i)][z_list.get(i)] = true;
            qx.add(x_list.get(i));
            qy.add(y_list.get(i));
            qz.add(z_list.get(i));
        }

        int length = 0;
        //int temp = qx.size();
        while (!qx.isEmpty() && !qy.isEmpty() && !qz.isEmpty()) {
            length = qx.size();
            for (int k = 0; k < length; k++) {
                int x = qx.poll();
                int y = qy.poll();
                int z = qz.poll();

                for (int i = 0; i < 6; i++) {
                    // tx ty tz는 인접한 점의 x,y,z 좌표이다.
                    // 이 반복문에서 추가로 발견이 되면 밑에서 map[tx][ty][tz] 값에 동일한 값이 추가로 발견된 곳에도 들어가게 됨!!

                    int tx = x + dy[i];
                    int ty = y + dx[i];
                    int tz = z + dz[i];

                    if (tx >= 0 && ty >= 0 && tx < n && ty < m && tz >= 0 && tz < d) {
                        System.out.println("ty: "+ ty + " tx: " + tx + " tz: " + tz);
                        if (map[ty][tx][tz] == 0 && !visit[ty][tx][tz]) {
                            qx.add(tx);
                            qy.add(ty);
                            qz.add(tz);
                            // temp = qx.size();
                            // 방문
                            ++error;
                            visit[ty][tx][tz] = true;
                            flag = true;
                            //System.out.println(tx + ", " + ty);
                            // 탐색횟수
                        }
                    }

                }

            }
            if (flag) {
                count++;
            }
            flag = false;
        }
        //System.out.println("error: " + error);
        if (error != n * m * d - (minus + temp_size)) {
            return (-1);
        } else {
            return count;
        }
    }
}