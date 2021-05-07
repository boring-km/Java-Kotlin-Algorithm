package study.programmers.string;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingScore {
    public static void main(String[] args) {
        System.out.println(solution(
                "blind",
                new String[]{
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
                }
        ));
    }

    public static int solution(String word, String[] pages) {
        int answer = 0;
        HashMap<String, Integer> insideMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> outsideMap = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            Pattern wordPattern = Pattern.compile("[\\W|0-9]" + word.toLowerCase() + "[\\W|0-9]");
            Matcher wordMatcher = wordPattern.matcher(page.toLowerCase());
            String[] others = new String[0];
            if (wordMatcher.find()) {
                String text = wordMatcher.group();
                others = page.toLowerCase().split(text.substring(1, text.length()-1));
            }
            int innerScore = others.length - 1;

            // 내부링크 이름 구하기
            Pattern keyPattern = Pattern.compile("<meta property=\"og:url\" content=\"(https://[\\S]*)\"/>");
            Matcher keyMatcher = keyPattern.matcher(page.toLowerCase());
            String key = "";
            if (keyMatcher.find()) {
                key = keyMatcher.group().replace("<meta property=\"og:url\" content=\"https://", "").replace("\"/>", "");
            }
            insideMap.put(key, innerScore);
            indexMap.put(key, i);

            // 외부링크 모두 구하기
            HashMap<String, Integer> outsideLinks = new HashMap<>();
            Pattern linkPattern = Pattern.compile("<a href=\"(https://[\\S]*)\">");
            Matcher linkMatcher = linkPattern.matcher(page.toLowerCase());
            while (linkMatcher.find()) {
                String text = linkMatcher.group().replace("<a href=\"https://", "").replace("\">", "");
                outsideLinks.put(text, outsideLinks.getOrDefault(text, 0) + 1);
            }

            outsideMap.put(key, outsideLinks);
        }
        double[] result = new double[pages.length];
        for (String key : insideMap.keySet()) {
            int index = indexMap.get(key);
            result[index] += insideMap.get(key);
            HashMap<String, Integer> map = outsideMap.get(key);
            for (String outKey : map.keySet()) {
                // 기본점수 / 외부 링크 수
                double outScore = (double) insideMap.get(key) / map.size();
                if (indexMap.containsKey(outKey))
                    result[indexMap.get(outKey)] += outScore;
            }
        }
        double maxi = 0;
        for (int i = 0; i < pages.length; i++) {
            if (maxi < result[i]) {
                answer = i;
                maxi = result[i];
            }
        }

        return answer;
    }
}
