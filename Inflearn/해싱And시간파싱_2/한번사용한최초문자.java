package 해싱And시간파싱_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class 한번사용한최초문자 {
    public static void main(String[] args) {
        String s = "aabb";

//        String s = "aabb";
        //3
        Map<Character, Integer> map = new LinkedHashMap<>();
        int index=0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean flag = false;
        int answer=0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            answer++;
            if (characterIntegerEntry.getValue() == 1) {
                flag = true;
                System.out.println(answer);
                break;
            }
        }
        if (flag == false) {
            System.out.println(-1);
        }
    }
}
