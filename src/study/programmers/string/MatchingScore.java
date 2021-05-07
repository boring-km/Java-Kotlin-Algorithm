package study.programmers.string;

import java.util.*;
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
        HashMap<String, Double> insideMap = new HashMap<>();
        HashMap<String, Double> outsideMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        word = word.toLowerCase();

        for (int i = 0; i < pages.length; i++) {
            String page = pages[i].toLowerCase();
            Pattern wordPattern = Pattern.compile("\\b" + word + "\\b");
            Matcher wordMatcher = wordPattern.matcher(page.replaceAll("[0-9]", " "));
            int innerScore = 0;
            while (wordMatcher.find()) {
                innerScore++;
            }

            // 내부링크
            Pattern keyPattern = Pattern.compile("<meta property=\"og:url\" content=\\S+/>");
            Matcher keyMatcher = keyPattern.matcher(page.split("</head>")[0]);
            String key = "";
            if (keyMatcher.find()) {
                key = keyMatcher.group().substring(32);
            }
            key = key.substring(0, key.length() - 2);
            indexMap.put(key, i);
            insideMap.put(key, (double) innerScore);

            // 외부링크
            Pattern linkPattern = Pattern.compile("<a href=\\S+>");
            Matcher linkMatcher = linkPattern.matcher(page);
            ArrayList<String> links = new ArrayList<>();
            while (linkMatcher.find()) {
                String link = linkMatcher.group();
                link = link.substring(8);
                link = link.substring(0, link.length() - 1);
                if (link.charAt(link.length() - 1) == 'a') {  // <a href=""></a> 경우
                    link = link.substring(0, link.length() - 4);
                }
                links.add(link);
            }
            for (String link : links) {
                outsideMap.put(link, outsideMap.getOrDefault(link, 0.0) + ((double) innerScore / links.size()));
            }
        }

        double maxi = 0;
        for (String key: insideMap.keySet()) {
            double score = insideMap.get(key);
            if(outsideMap.containsKey(key)) {
                score += outsideMap.get(key);
            }
            if(score > maxi) {
                answer = indexMap.get(key);
                maxi = score;
            } else if (score == maxi) {
                answer = Math.min(answer, indexMap.get(key));
            }
        }

        return answer;
    }
}
