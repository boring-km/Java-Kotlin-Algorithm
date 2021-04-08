package study.programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }

    public static int[] solution(String s) {
        int[] answer;
        int n = s.length();
        String setString = s.substring(1, n-1);
        n = setString.length();

        StringBuilder cur = new StringBuilder();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean isOpen = false;

        for (int i = 0; i < n; i++) {
            if (setString.charAt(i) == '{') {
                isOpen = true;
            } else if (setString.charAt(i) == '}') {
                String[] array = cur.toString().split(",");
                int size = array.length;
                ArrayList<Integer> temp = new ArrayList<>();
                for (String value : array) {
                    temp.add(Integer.parseInt(value));
                }
                map.put(size, temp);
                cur = new StringBuilder();
                isOpen = false;
            } else {
                if (isOpen)
                    cur.append(setString.charAt(i));
            }
        }
        ArrayList<Integer> previous = new ArrayList<>();
        for (int key: map.keySet()) {
            ArrayList<Integer> res = map.get(key);
            ArrayList<Integer> next = new ArrayList<>(res);

            int prev_size = previous.size();
            int count = 0;
            for (int i = 0; i < prev_size; i++) {
                if (previous.contains(res.get(i))) {
                    next.remove(i - count);
                    count++;
                } else {
                    previous.add(res.get(i));
                    break;
                }
            }
            if (count == prev_size) previous.add(next.get(0));
        }
        answer = new int[previous.size()];
        for (int i = 0; i < previous.size(); i++) {
            answer[i] = previous.get(i);
        }

        return answer;
    }
}
