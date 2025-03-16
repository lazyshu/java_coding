package greedy_5;

import java.util.*;

public class 꽃이피최단시간_4 {
    public static void main(String[] args) {
        int[] plantTime = {1, 3, 2};
        int[] growTime = {2, 3, 2};
        int answer = 8;
        int[] plantTime2 = {2, 1, 4, 3};
        int[] growTime2 = {2, 5, 3, 1};
        int answer2 = 11;
        int[] plantTime3 = {1, 1, 1};
        int[] growTime3 = {7, 3, 2};
        int answer3 = 8;
        int[] plantTime4 = {5, 7, 10, 15, 7, 3, 5};
        int[] growTime4 = {6, 7, 2, 10, 15, 6, 7};
        int answer4 = 54;
        int[] plantTime5 = {1, 2, 3, 4, 5, 6, 7};
        int[] growTime5 = {7, 5, 4, 3, 2, 1, 6};
        int answer5 = 29;
        System.out.println("solution 1" + (solution(plantTime, growTime) == answer));
        System.out.println("solution 2" + (solution(plantTime2, growTime2) == answer2));
        System.out.println("solution 3" + (solution(plantTime3, growTime3) == answer3));
        System.out.println("solution 4" + (solution(plantTime4, growTime4) == answer4));
        System.out.println("solution 5" + (solution(plantTime5, growTime5) == answer5));
    }

    private static int solution(int[] plantTime, int[] growTime) {
        int[][] sortedTime = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            sortedTime[i][0] = plantTime[i];
            sortedTime[i][1] = growTime[i];
        }
        Arrays.sort(sortedTime,
                (Comparator.comparingInt((int[] a) -> a[1])).reversed());
        //growTime 긴 순으로 정렬 먼저 해야함! *-*


        int[] calculatedTime = new int[growTime.length];
        calculatedTime[0] = sortedTime[0][0];
        int max = calculatedTime[0] + sortedTime[0][1];

        for (int i = 1; i < growTime.length; i++) {
            calculatedTime[i] = calculatedTime[i - 1] + sortedTime[i][0];
            max = Math.max(max, calculatedTime[i] + sortedTime[i][1]);
        }


        return max;
    }
}
