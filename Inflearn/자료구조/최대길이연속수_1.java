package 자료구조;

import java.util.Arrays;


public class 최대길이연속수_1 {
    public static void main(String[] args) {

        int[] nums1 = {8, 1, 9, 3, 10, 2, 4, 0, 2, 3};
        //5
        System.out.println("answer for solution(nums1)= " + solution(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0};
        //10
        System.out.println("answer for solution(nums2)= " + solution(nums2));

        int[] nums3 = {3, 3, 3, 3, 3, 3, 3, 3};
        //1
        System.out.println("answer for solution(nums3)= " + solution(nums3));

        int[] nums4 = {-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1};
        //7
        System.out.println("answer for solution(nums4)= " + solution(nums4));

        int[] nums5 = {-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7};
        //3
        System.out.println("answer for solution(nums5)= " + solution(nums5));


    }

    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
                continue;
            }
            if (nums[i - 1] != nums[i]) {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(count,max);

    }
}
