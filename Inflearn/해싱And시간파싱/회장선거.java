package 해싱And시간파싱;

import java.util.*;

public class 회장선거 {
    public static void main(String[] args) {
        String[] votes = {"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"};
        int k=3;
        solution(votes, k);


    }

    private static void solution(String[] votes, int k) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            String[] vote= votes[i].split(" ");
            if (map.containsKey(vote[1])) {
                map.get(vote[1]).add(vote[0]);
            } else {
                map.put(vote[1], new ArrayList<>(Collections.singletonList(vote[0])));
            }
        }
        List<String> candidates = new ArrayList<>();
        HashMap<String, Integer> selectedStudents = new HashMap<>();
        int max=0;
        for (String string : map.keySet()) {
            if (map.get(string).size() >= k) {  //k보다 많이 투표 받은 인간들..
                candidates.add(string);
                List<String> students = map.get(string);
                for (String student : students) {  // //k보다 많이 투표 받은 인간들..을 뽑은 인간들!
                    selectedStudents.put(student, selectedStudents.getOrDefault(student, 0) + 1);
                    max = Math.max(max, selectedStudents.get(student));
                }
            }
        }
        List<String> giftTo = new ArrayList<>();
        for (String string : selectedStudents.keySet()) {
            if (selectedStudents.get(string) == max) {
                giftTo.add(string);
            }
        }
        System.out.println(giftTo.stream().sorted().findFirst().get());
    }
}
