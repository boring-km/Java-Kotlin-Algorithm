package study.programmers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/1830
public class Programmers_1830 {

    // 규칙 1: 한 단어의 사이사이마다 같은 소문자 넣기
    // 규칙 2: 한 단어의 양 끝에 같은 소문자 넣기
    private static String solution(String s) {

        char[] sentence = s.toCharArray();
        String invalid = "invalid";

        try {
            Map<Character, List<Integer>> map = new LinkedHashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = sentence[i];
                if (c >= 'a' && c <= 'z') {
                    if (!map.containsKey(c)) {
                        map.put(c, new ArrayList<>());
                    }
                    map.get(c).add(i);
                }
            }
            StringBuilder answer = new StringBuilder();

            int listSize, startChar, endChar;
            int startString = 0, startWord = 0, endWord = 0, length = 0, rule = 0;
            int startWordBefore = -1, endWordBefore = -1, startCharBefore = -1, endCharBefore = -1;

            for (List<Integer> positions: map.values()) {
                listSize = positions.size();
                startChar = positions.get(0);
                endChar = positions.get(listSize - 1);

                if (listSize == 1 || listSize >= 3) { // 규칙 1만 해당됨
                    for (int i = 1; i < listSize; i++) {
                        // 규칙 1도 아니라면
                        if (positions.get(i) - positions.get(i - 1) != 2) {
                            return invalid;
                        }
                    }
                    rule = 1;
                } else {
                    // 규칙 1일수도 2일수도
                    length = endChar - startChar;
                    if (length == 2 && (startCharBefore < startChar && endChar < endCharBefore)) {
                        rule = 1;
                    } else if (length >= 2) {
                        rule = 2;
                    } else {
                        return invalid;
                    }
                }
                if (rule == 1) { // 규칙 1은 앞뒤로 대문자까지 포함
                    startWord = startChar - 1;
                    endWord = endChar + 1;
                    if (startWordBefore < startWord && endWord < endWordBefore) {
                        if (startChar - startCharBefore == 2 && endCharBefore - endChar == 2) {
                            continue;
                        } else {
                            return invalid;
                        }
                    }
                } else {
                    startWord = startChar;  // 시작 단어가 소문자부터
                    endWord = endChar;  // 마지막 단어도 소문자부터
                    if (startWordBefore < startWord && endWord < endWordBefore) {
                        return invalid;
                    }
                }

                if (endWordBefore >= startWord) {
                    return invalid;
                }

                if (startString < startWord) {
                    answer.append(getBigString(startString, startWord - 1, sentence)).append(" ");
                }
                answer.append(getBigString(startWord, endWord, sentence)).append(" ");
                startWordBefore = startWord;
                endWordBefore = endWord;
                startCharBefore = startChar;
                endCharBefore = endChar;
                startString = endWord + 1;
            }
            if (startString < len) {
                answer.append(getBigString(startString, len-1, sentence));
            }
            return answer.toString().trim();
        } catch (Exception e) {
            return invalid;
        }
    }

    private static String getBigString(int start, int end, char[] sentence) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            char c = sentence[i];
            if ('A' <= c && c <= 'Z') {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = solution("xKx");
        System.out.println(result);
    }
}
