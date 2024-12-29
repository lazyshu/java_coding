package sortingAndThinking_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 심사위원_4 {
    /**
     *32분 뿌앵
     */
    public static void main(String[] args) {
        int[] nums_1 = {99, 97, 80, 91, 85, 95, 92};
        int k=3;
        int answer_1 = 89;
        System.out.println("answer_1 = " + (answer_1 == solution(nums_1,k)));

        int[] nums_2 = {92, 90, 77, 91, 70, 83, 89, 76, 95, 92};
        int k2=4;
        int answer_2 = 88;
        System.out.println("answer_2 = " + (answer_2 == solution(nums_2,k2)));

        int[] nums_3 = {77, 88, 78, 80, 78, 99, 98, 92, 93, 89};
        int k3=5;
        int answer_3 = 92;
        System.out.println("answer_3 = " + (answer_3 == solution(nums_3,k3)));

        int[] nums_4 = {88, 99, 91, 89, 90, 72, 75, 94, 95, 100};
        int k4=5;
        int answer_4 = 90;
        System.out.println("answer_4 = " + (answer_4 == solution(nums_4,k4)));
    }

    private static int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;

        for (int i = 0; i < nums.length-k; i++) {
            if ((nums[i + k-1]-nums[i]) <= 10) {
                for (int j = i; j < i+k; j++) {
                    sum += nums[j];

                }break;
            }
        }
        return sum/k;
    }
}
