package sortingAndThinking_4;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class 이진수정렬 {
    public static void main(String[] args) {
        int[] nums_1 = {5, 6, 7, 8, 9};
        int[] answer_1 = {8, 5, 6, 9, 7};
        System.out.println("answer_1= " + Arrays.equals(answer_1, solution(nums_1)));
        System.out.println("actual answer_1 = " + Arrays.equals(answer_1,actualSolution(nums_1)));

        int[] nums_2 = {5, 4, 3, 2, 1};
        int[] answer_2 = {1, 2, 4, 3, 5};
        System.out.println("answer_.2 = " + Arrays.equals(answer_2, solution(nums_2)));
        System.out.println("actual answer_2 = " + Arrays.equals(answer_2,actualSolution(nums_2)));

        int[] nums_3 = {12, 5, 7, 23, 45, 21, 17};
        int[] answer_3 = {5, 12, 17, 7, 21, 23, 45};
        System.out.println("answer_3 = " + Arrays.equals(answer_3, solution(nums_3)));
        System.out.println("actual answer_3 = " + Arrays.equals(answer_3,actualSolution(nums_3)));

    }

    private static int[] actualSolution(int[] nums) {
        int[] answer = new int[nums.length];
        int[][] sortCounts = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            sortCounts[i][0] = nums[i];
            sortCounts[i][1] = Integer.bitCount(nums[i]);
        }
        Arrays.sort(sortCounts,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sortCounts[i][0];
        }
        return answer;
    }

    private static int[] solution(int[] nums) {
        /*
        *못풀고 지피티한테 물어보면서 함.
        * Integer.bitCount(nums[i]); 이거는 하드웨어 수준에서 최적화 된것.
        * TreeMap안에 PriorityQueue 사용하면 배열보다 메모리 사용량이 큼 :(
        *
        * Arrays.sort(sortCounts,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        * 요거 외우기 :(
         */
        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int count = Integer.bitCount(nums[i]);
            treeMap.putIfAbsent(count, new PriorityQueue<>());
            System.out.println("count = " + count);
            treeMap.get(count).add(nums[i]);
            System.out.println("nums = " + nums[i]);
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> integerPriorityQueueEntry : treeMap.entrySet()) {
            System.out.println("integerPriorityQueueEntry.getKey() = " + integerPriorityQueueEntry.getKey());
            System.out.println("integerPriorityQueueEntry.getValue() = " + integerPriorityQueueEntry.getValue());
        }
        int[] answer = new int[nums.length];
        int index=0;
        while (!treeMap.isEmpty()){
            PriorityQueue<Integer> smallestCount = treeMap.pollFirstEntry().getValue();
            System.out.println("smallestCount = " + smallestCount);
            for (Integer integer : smallestCount) {
                System.out.println("integer = " + integer);
            }
            while (!smallestCount.isEmpty()) {
                answer[index++] = smallestCount.poll();
            }
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }

}
