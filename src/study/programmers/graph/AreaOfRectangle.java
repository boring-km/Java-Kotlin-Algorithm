package study.programmers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AreaOfRectangle {
    public static void main(String[] args) {

    }

    public static long solution(int[][] rectangles) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        long answer = 0;
        for (int[] item : rectangles) {
            int sx = item[0];
            int sy = item[1];
            int ex = item[2];
            int ey = item[3];
            for (int y = sy; y < ey; y++) {
                for (int x = sx; x < ex; x++) {
                    if (!map.containsKey(y)) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(x);
                        map.put(y, list);
                        answer++;
                    } else {
                        ArrayList<Integer> temp = map.get(y);

                    }
                }
            }
        }
        return answer;
    }
}
