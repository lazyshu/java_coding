package greedy_5;

import com.sun.jdi.Value;

import java.util.*;

public class 전투게임_5 {
    public static void main(String[] args) {
        //10,11,12,12,20
        String[] students1 = {"a 20", "b 12", "a 10", "c 11", "e 12"};
        int[] answer1 = {35, 21, 0, 10, 21};
        System.out.println("answer1 = " + Arrays.equals(answer1, solution(students1)));

        String[] students2 = {"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"};
        int[] answer2 = {35, 21, 0, 10, 38, 59, 21};
        System.out.println("answer2 = " + Arrays.equals(answer2, solution(students2)));

        String[] students3 = {"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"};
        int[] answer3 = {15, 23, 82, 0, 15, 82, 0};
        System.out.println("answer3 = " + Arrays.equals(answer3, solution(students3)));

        String[] students4 = {"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"};
        int[] answer4 = {45, 20, 20, 0, 0, 20, 75};
        System.out.println("answer4 = " + Arrays.equals(answer4, solution(students4)));

    }

    private static int[] solution(String[] students) {
//        a 20", "b 12", "a 10", "c 11", "e 12
        //팀 별로 점수 넣어두기!
        List<String> list = List.of(students);
        int[][] pair = new int[list.size()][3];

        for (int i = 0; i < pair.length; i++) {
            String[] st = list.get(i).split(" ");
            pair[i][0] = st[0].charAt(0); //팀이름
            pair[i][1] = Integer.parseInt(st[1]); //공격력
            pair[i][2] = i; //원래 pair의 index위치
        }

        int[] answer = new int[pair.length];
        //20,12,12,10,11
        //공격력 높은 순 정렬
        pair = Arrays.stream(pair).sorted(Comparator.comparing((int[] a) -> a[1]).reversed()).toArray(int[][]::new);

        //같은 팀 제외, 같은 공격력 제외하고 answer에 포인트 더하기.
        for (int i = 0; i < pair.length - 1; i++) {
            for (int j = i + 1; j < pair.length; j++) {
                int index = pair[i][2];
                if (pair[i][0] != pair[j][0] && pair[i][1] != pair[j][1]) {
                    answer[index] += pair[j][1];
                }
            }
        }

        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
}
