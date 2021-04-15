package study.programmers.practice;

import java.util.HashMap;

public class Shiritori {
    public static void main(String[] args) {
        int[] result = solution(
                2, new String[] {
                        "hello", "one", "even", "never", "now", "world", "draw"
                }
        );
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        int size = words.length;

        HashMap<String, Boolean> dict = new HashMap<>();
        char before = words[0].charAt(0);
        for (int i = 0; i < size; i++) {
            char first = words[i].charAt(0);
            if (first != before) {
                answer = new int[]{(i % n)+1, (i / n)+1};
                break;
            }
            if (dict.containsKey(words[i])) {
                answer = new int[]{(i % n)+1, (i / n)+1};
                break;
            } else {
                dict.put(words[i], true);
            }
            before = words[i].charAt(words[i].length()-1);
        }
        return answer;
    }
}
