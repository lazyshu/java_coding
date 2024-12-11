package 해싱And시간파싱;

import java.util.*;

public class 서로다른빈도수만들기 {
    public static void main(String[] args) {
        String input = "aaabbbcccdddeeeeeff";
        List<Integer> li = new ArrayList<>();

        char[] chArr = input.toCharArray();
        char letter = chArr[0];
        int count=1;
        for (int i = 1; i < chArr.length; i++) {
            if (letter == chArr[i]) {
                count++;
                continue;
            }
            li.add(count);
            letter = chArr[i];
            count=1;
        }
        li.add(count);
        li.sort(Collections.reverseOrder());

        int answer=0;
        int min=li.getFirst();
        for (int i = 1; i < li.size(); i++) {

            if (min == 1) {
                answer += li.get(i);
                continue;
            }
            if (li.get(i-1).equals(li.get(i))||li.get(i).equals(min)) {
                min -= 1;
                answer+= li.get(i)-min;
                continue;
            }
            min=li.get(i);
        }
        System.out.println("answer = " + answer);
        int actualAnswer = actualAnswer(input);
        System.out.println("actualAnswer = " + actualAnswer);
    }

    public static int actualAnswer(String input) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char c : input.toCharArray()) {
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        int count=0;
        //hs a-3 ,b-3,c-3,d-3,e-5,f-2
        HashSet<Integer> ch = new HashSet<>(); //이건 set이니 같은건 존재하지않음.
        for (Character c : hs.keySet()) {
            while (ch.contains(hs.get(c))) {
                hs.put(c, hs.get(c) - 1);
                count++;
            }
            if (hs.get(c) == 0) {

                continue; //요거 중요하당. 0이면 ch에 담으면 앙대!
            }
            ch.add(hs.get(c));
        }
        return count;
    }
}
