package study.programmers.practice;

import java.util.*;

// 풀이시간 부족
// 가장 깔끔한 풀이: https://wellbell.tistory.com/104
public class RankSearching {
    public static void main(String[] args) {
        int[] result = solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
        Arrays.stream(result).forEach(num -> System.out.println(num));
    }
    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // Map 안에 List sorting
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            entry.getValue().sort(null);
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] splits = query[i].replaceAll("-", "").replaceAll(" and ", "").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int start = 0;
            int end = list.size();
            // lower bound 를 구해야 함
            while (start < end) {
                int mid = (start + end) / 2;
                if(list.get(mid) < score) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            // 전체에서 lower bound를 빼면 score와 같거나 큰 경우의 수
            answer[i] = list.size() - start;
        }
        return answer;
    }
}
