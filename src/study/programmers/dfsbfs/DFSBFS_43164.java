package study.programmers.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 1시간 32 + 알파
public class DFSBFS_43164 {
    public static void main(String[] args) {
//        String[] result = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"},
//                {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        String[] result = solution(new String[][]{{"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "BBA"}});
        for (String item : result) {
            System.out.println("ans:" + item);
        }

    }
    public static String[] solution(String[][] tickets) {
        String[] answer;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            ArrayList<String> targetList;
            if (map.containsKey(start)) {
                targetList = map.get(start);
            } else {
                targetList = new ArrayList<>();
            }
            targetList.add(end);
            map.put(start, targetList);
        }

        Queue<String> ticketQueue = new LinkedList<>();
        ArrayList<String> road = new ArrayList<>();
        ticketQueue.add("ICN");

        while (!ticketQueue.isEmpty()) {
            String start = ticketQueue.poll();
            road.add(start);
            ArrayList<String> targetList = map.getOrDefault(start, new ArrayList<>());
            if (targetList.isEmpty()) {
                break;
            }

            int count = 0;
            for (String s : targetList) {
                if (visited.getOrDefault(start + s, false)) {
                    count++;
                }
            }
            if (count == targetList.size()) {
                break;
            }

            String target = "ZZZ";
            for (String s : targetList) {
                if (s.compareTo(target) < 0 && !visited.getOrDefault(start+s, false)) {
                    // 여러 경우일 때 다시 돌아오는 문자인지 여기서 확인
                    if (targetList.size() > 1) {
                        // start -> s  ... s -> start 확인
                        if(dfs(start, s, map).equals(start)) {
                            target = s;
                        }
                    } else {
                        target = s;
                    }
                }
            }
            ticketQueue.add(target);
            visited.put(start+target, true);
        }
        int placeCount = road.size();
        answer = new String[placeCount];
        for (int i = 0; i < placeCount; i++) {
            answer[i] = road.get(i);
        }

        return answer;
    }

    public static String dfs(String start, String target, HashMap<String, ArrayList<String>> map) {

        ArrayList<String> innerList = map.getOrDefault(target, new ArrayList<>());
        if (innerList.isEmpty()) {
            return target;
        }
        if (innerList.size() == 1) {
            return innerList.get(0);
        }
        for (String s : innerList) {
            String result = dfs(start, s, map);
            if (result.equals(start)) {
                return start;
            }
        }
        return target;
    }
}
