package study.programmers.stackqueue;

import java.util.*;

public class ChuseokTraffic {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        }));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        int n = lines.length;   // 최대 2000개

        int[][] timelines = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] t = lines[i].split(" ");
            String[] endTimeString = t[1].split(":");
            int end_hh = Integer.parseInt(endTimeString[0]) * 3600000;
            int end_mm = Integer.parseInt(endTimeString[1]) * 60000;
            int end_ss = Integer.parseInt(endTimeString[2].replace(".", ""));

            int term = (int) (Double.parseDouble(t[2].replace("s", "")) * 1000);
            int endTime = end_hh + end_mm + end_ss;
            int startTime = endTime - term + 1;
            timelines[i][0] = startTime;
            timelines[i][1] = endTime;  // 여기서 timelines는 완료시간 기준으로 정렬된 배열
        }
        answer = getMaximum(answer, n, timelines, new LinkedList<>());
        Arrays.sort(timelines, Comparator.comparingInt(o -> o[0])); // 시작 시간 기준으로 정렬 후 똑같은 알고리즘 다시 실행
        answer = getMaximum(answer, n, timelines, new LinkedList<>());

        return answer;
    }

    private static int getMaximum(int answer, int n, int[][] timelines, Queue<Integer> endTimeQueue) {
        for (int i = 0; i < n; i++) {
            int[] temp = timelines[i];
            int startTime = temp[0];
            int endTime = temp[1];
            int extra = 0;
            ArrayList<Integer> tempList = new ArrayList<>();
            while (!endTimeQueue.isEmpty()) {
                int tempEnd = endTimeQueue.poll();
                int target = startTime - tempEnd;
                if (target == 999) {
                    extra++;
                }
                if (target < 999){
                    tempList.add(tempEnd);
                }
            }
            endTimeQueue.addAll(tempList);
            endTimeQueue.add(endTime);
            answer = Math.max(answer, endTimeQueue.size() + extra);
        }
        return answer;
    }
}
