package study.codility;

import java.util.HashMap;
import java.util.Map;

public class Leader_1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int N = A.length;
        int dominator = 0;
        boolean isExist = false;
        for (int item : A) {
            int saved = map.getOrDefault(item, 0);
            map.put(item, saved+1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > N / 2) {
                dominator = key;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            for (int i = 0; i < N; i++) {
                if (A[i] == dominator) {
                    return i;
                }
            }
        }
        return -1;
    }
}
