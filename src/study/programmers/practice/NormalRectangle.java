package study.programmers.practice;

public class NormalRectangle {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long answer = 1;
        double slope = (double)h / (double) w;
        for (int y = 1; y < h; y++) {
            for (int x = 1; x < w; x++) {
                if (slope > (double) y/ (double) x && slope < (double) y+1 / (double) x) {
                    System.out.println(y + " " + x);
                    answer++;
                }
            }
        }
        return answer;
    }
}
