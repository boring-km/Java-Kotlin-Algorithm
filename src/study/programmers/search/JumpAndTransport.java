package study.programmers.search;

public class JumpAndTransport {
    public static void main(String[] args) {

        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                ans++;
                n -= 1;
            }
        }
        return ans;
    }
}
// 2500 1
// 1250 2
// 625 3

// 5 <- 2

// 1 2*2 2*2 + 1
// 1 2*1 2*1+1 (2*1+1)*2
// 2**3 5**4