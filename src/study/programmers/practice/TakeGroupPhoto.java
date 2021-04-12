package study.programmers.practice;

import java.util.ArrayList;

// 1시간 30분
public class TakeGroupPhoto {

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{
                "M~C<2", "C~M>1"
        }));
    }

    public static int solution(int n, String[] data) {
        String[] itemArray = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        ArrayList<String> allList = new ArrayList<>();
        String[] res = new String[itemArray.length];

        perm(itemArray, 0, 8, res, allList);

        for (int i = 0; i < n; i++) {
            char start = data[i].charAt(0);
            char end = data[i].charAt(2);
            char check = data[i].charAt(3);
            int dist = data[i].charAt(4) - '0';
            ArrayList<String> temp = new ArrayList<>();
            for (String s : allList) {
                int sIndex = -1;
                int eIndex = -1;
                for (int k = 0; k < 8; k++) {
                    if (sIndex != -1 && eIndex != -1) break;
                    if (s.charAt(k) == start) sIndex = k;
                    if (s.charAt(k) == end) eIndex = k;
                }
                int checkDist = Math.abs(eIndex - sIndex) - 1;
                if (check == '<' && checkDist < dist) {
                    temp.add(s);
                } else if (check == '>' && checkDist > dist) {
                    temp.add(s);
                } else if (check == '=' && checkDist == dist) {
                    temp.add(s);
                }
            }
            allList = temp;
        }

        return allList.size();
    }

    public static void perm(String[] arr, int depth, int n, String[] res, ArrayList<String> allList) {

        // depth가 0부터 시작했을 경우 depth == r에서 리턴
        if (depth == n) {

            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                temp.append(res[i]);
            }
            allList.add(temp.toString());
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);     // 스왑
            res[depth] = arr[depth]; // 선택된 원소 저장
            perm(arr, depth+1, n, res, allList);     // 재귀호출
            swap(arr, depth, i);     // 복원
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
