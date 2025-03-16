package 깊이우선탐색_6;

import java.util.*;

public class 팰린드롬_4 {
    /**
     * 이것두 포기 :( 
     */
    public static void main(String[] args) {
        String s_1 = "aaaabb";
        String s_2 = "abbcc";
        String s_3 = "abbccee";
        String s_4 = "abbcceee";
        String s_5 = "ffeffaae";
        solution(s_1);
    }
    static List<String> answer;

    private static void solution(String s) {
        answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entrySets = new ArrayList<>(map.entrySet());
        entrySets.sort((a,b)->a.getValue().compareTo(b.getValue()));

        //a=4,b=2
        System.out.println("entrySets = " + entrySets);
        dfs(s.length(),entrySets);

    }

    private static void dfs(int stringLength,List<Map.Entry<Character, Integer>> entrySets) {
        if (stringLength % 2 == 0) {

        }
    }
}
