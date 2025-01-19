package sortingAndThinking_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 수열찾기_2 {
    public static void main(String[] args) {
        int[] nums_1 = {1, 10, 2, 3, 5, 6};
        int[] answer_1 = {1, 3, 5};
        System.out.println("answer_1 = " + Arrays.equals(answer_1, solution(nums_1)));
        System.out.println("Hashmap- answer_1 = " + Arrays.equals(answer_1, HashMapSolution(nums_1)));


        int[] nums_2 = {1, 1, 6, 2, 2, 7, 3, 14};
        int[] answer_2 = {1, 1, 3, 7};
        System.out.println("answer_2 = " + Arrays.equals(answer_2, solution(nums_2)));
        System.out.println("Hashmap- answer_2 = " + Arrays.equals(answer_2, HashMapSolution(nums_2)));


        int[] nums_3 = {14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14};
        int[] answer_3 = {2, 3, 5, 5, 7, 7};
        System.out.println("answer_3 = " + Arrays.equals(answer_3, solution(nums_3)));
        System.out.println("Hashmap- answer_3 = " + Arrays.equals(answer_3, HashMapSolution(nums_3)));

    }

    private static int[] HashMapSolution(int[] nums) {
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int answerIndex = 0;
        //1,2,3,5,6,10
        for (Integer num : nums) {

            if (hm.get(num) == null || hm.get(num) == 0) { //value가 0이면 비워진거다. 이미 처리가 끝나서 스킵.
                continue;
            }
            answer[answerIndex] = num;
            answerIndex++;
            hm.put(num, hm.get(num) - 1); // 중복이 있어서 하나씩 value에서 뺴준다.

            hm.put(num * 2, hm.get(num * 2) - 1); //두배인 수도 찾아서 Value에서 하나르 빼준다

        }
        return answer;
    }

    private static int[] solution(int[] nums) {
        /**
         *
         * 1시간 5분 걸림- 답지가 사용한 hashmap이 더 성능이 좋다고 함 :(
         */


        //num 는 정렬되어 있지 않다.
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(null);


        int listIndex = 0;
        int[] answer = new int[nums.length / 2];

        while (list.size() > nums.length / 2) {
            int originalNo = list.get(listIndex);
            int doubleIndex = list.indexOf(originalNo * 2);

            if (doubleIndex > -1) { //두배의 값이 존재한다면 실행된다.
                list.remove(doubleIndex); //1,2,3,5,6,10<---여기서 1의 두배 값인 2를 list에서 제거한다.
            }
            answer[listIndex++] = originalNo; // 지금 인덱스의 숫자를 answer에 넣어준다.

        }
        return answer;
    }

}
