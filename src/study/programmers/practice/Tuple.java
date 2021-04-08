package study.programmers.practice;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,2,3},{2}}")));
    }

    public static int[] solution(String s) {
        Set<String> set = new HashSet<>();
        // 알맹이만 쏙 뽑아내는 기가 막히는 방법
        // 중괄호 제거
        // 배열 사이마다 있는 comma 제거
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        // 배열이 들어간 문자열을 길이별로 정렬함
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        // 배열 길이가 곧 정답의 길이
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                // 집합에 값이 추가된다면 새로운 answer에 담음 (중복되는 원소가 주어지지 않기 때문에 set으로 처리 가능함..)
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
