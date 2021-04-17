package study.programmers.practice;

import java.util.Deque;
import java.util.LinkedList;

public class CityCache {
    public static void main(String[] args) {
        System.out.println(solution(5,
                new String[]{
                        "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
                }));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int size = cities.length;
        if (cacheSize == 0) {
            return size * 5;
        }
        Deque<String> cache = new LinkedList<>();

        for (String s : cities) {
            String city = s.toLowerCase();
            boolean check = false;
            if (cache.contains(city)) {
                check = true;
                cache.remove(city);
                cache.push(city);
            }
            if (check) {
                answer++;
            } else {
                if (cache.size() == cacheSize)
                    cache.pollLast();
                cache.push(city);
                answer += 5;
            }
        }

        return answer;
    }

}
