package sortingAndThinking_4;

import java.util.Arrays;

public class 카드가져가기_3 {
    public static void main(String[] args) {
        int[] nums_1={7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k_1 = 2;
        int answer_1 = 28;
        System.out.println("answer_1 = "+(answer_1==solution(nums_1,k_1)));

        int[] nums_2={7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k_2 = 2;
        int answer_2 = 28;
        System.out.println("answer_2 = "+(answer_2==solution(nums_2,k_2)));

        int[] nums_3={7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k_3 = 2;
        int answer_3 = 28;
        System.out.println("answer_3 = "+(answer_3==solution(nums_3,k_3)));

        int[] nums_4={7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k_4 = 2;
        int answer_4 = 28;
        System.out.println("answer_4 = "+(answer_4==solution(nums_4,k_4)));

        int[] nums_5={7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k_5 = 2;
        int answer_5 = 28;
        System.out.println("answer_5 = "+(answer_5==solution(nums_5,k_5)));
    }

    private static int solution(int[] nums,int k) {
        Arrays.sort(nums);
        int max=0;
        for (int i = 0; i < nums.length; i+=2) {
            int hyunsoo = nums[i];
            int younghee = nums[i + 1];
            if (k > 0 && younghee > hyunsoo) {
                k--;
                hyunsoo = younghee;
            }
            max += hyunsoo;
        }
        return max;
    }
}
