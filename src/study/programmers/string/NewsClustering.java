package study.programmers.string;

import java.util.ArrayList;
import java.util.HashMap;

// 2시간 이상 걸림
public class NewsClustering {
    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    public static int solution(String str1, String str2) {
        int answer;
        double count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int length1 = str1.length();
        for (int i = 0; i < length1-1; i++) {
            String temp = str1.substring(i, i+2).toLowerCase();
            int check = 0;
            for (int j = 0; j < 2; j++) {
                if (97 <= (int) temp.charAt(j) && (int) temp.charAt(j) <= 122) {
                    check++;
                }
            }
            if (check == 2) {
                int next = map.getOrDefault(temp.toLowerCase(), 0);
                map.put(temp.toLowerCase(), next+1);
            }
        }
        int mapSize = 0;
        for (int num : map.values()) {
            mapSize += num;
        }

        HashMap<String, Integer> secondMap = new HashMap<>();
        int length2 = str2.length();
        ArrayList<String> addlist = new ArrayList<>();
        for (int i = 0; i < length2-1; i++) {
            String temp = str2.substring(i, i+2).toLowerCase();
            if (map.containsKey(temp)) {
                count++;
                int value = map.get(temp);
                if (value == 1) {
                    map.remove(temp);
                } else {
                    map.put(temp, value-1);
                }
                int next = secondMap.getOrDefault(temp, 0);
                secondMap.put(temp, next+1);
            } else {
                int check = 0;
                for (int j = 0; j < 2; j++) {
                    if (97 <= (int) temp.charAt(j) && (int) temp.charAt(j) <= 122) {
                        check++;
                    }
                }
                if (check == 2) {
                    int next = secondMap.getOrDefault(temp, 0);
                    secondMap.put(temp, next+1);
                }
            }
        }
        for (int num : secondMap.values()) {
            mapSize += num;
        }
        mapSize -= count;
        if (count == 0 && mapSize == 0) answer = 65536;
        else answer = (int) (count / mapSize * 65536);

        return answer;
    }
}
