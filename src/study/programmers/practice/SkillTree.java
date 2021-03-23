package study.programmers.practice;

public class SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int n = skill_trees.length;
        for (String skill_tree : skill_trees) {
            int skill_index = 0;
            for (int j = 0; j < skill_tree.length(); j++) {
                char target = skill_tree.charAt(j);
                if (target == skill.charAt(skill_index)) {
                    skill_index++;
                } else {
                    if (isImpossible(skill, skill_index, target)) {
                        answer--;
                        break;
                    }
                }
                if (skill_index == skill.length()) {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }

    private static boolean isImpossible(String skill, int skill_index, char target) {
        for (int i = skill_index + 1; i < skill.length(); i++) {
            if (target == skill.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
