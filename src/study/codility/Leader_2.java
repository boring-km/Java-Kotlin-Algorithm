package study.codility;

import java.util.HashMap;
import java.util.Map;

public class Leader_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1}));
    }

    public static int solution(int[] A) {
        int n = A.length;
        int answer = 0;
        for (int k = 0; k < n; k++) {
            Map<Integer, Integer> frontMap = new HashMap<>();
            Map<Integer, Integer> backMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (i <= k) {
                    int saved = frontMap.getOrDefault(A[i], 0);
                    frontMap.put(A[i], saved+1);
                } else {
                    int saved = backMap.getOrDefault(A[i], 0);
                    backMap.put(A[i], saved+1);
                }
            }
            int backSize = n - k-1;
            int frontCount = frontMap.getOrDefault(A[k], 0);
            int backCount = backMap.getOrDefault(A[k], 0);
            if (frontCount > k / 2 && (backCount > backSize / 2 || backSize == 0)) {
                answer++;
            }
        }

        return answer;
    }
}
