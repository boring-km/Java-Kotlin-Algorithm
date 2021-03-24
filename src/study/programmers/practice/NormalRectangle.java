package study.programmers.practice;

import java.math.BigInteger;

public class NormalRectangle {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();  // w와 h 중에 더 큰 값 구하기
        long area = ((long) w * (long) h);
        long excluded = (long) w + (long) h - gcd;
        return area - excluded;
    }
}
