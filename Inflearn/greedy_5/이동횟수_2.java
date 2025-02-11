package greedy_5;

import java.util.Arrays;

public class 이동횟수_2 {
    public static void main(String[] args) {
        //흐규 47분 걸림 왜지 :(
        int[] nums1 = {2, 5, 4, 2, 3};
        int ans1=4;
        int[] nums2 = {2, 3, 4, 5};
        int ans2=3;
        int[] nums3 = {3,3,3,3, 3};
        int ans3=5;
        System.out.println("answer 1="+(solution(nums1)==ans1));
        System.out.println("answer 2="+(solution(nums2)==ans2));
        System.out.println("answer 3="+(solution(nums3)==ans3));
    }

    private static int solution(int[] nums) {
        int count=0;
        int sum=0; //5
        Arrays.sort(nums);
        int left=0;
        int right = nums.length - 1;
        //2,2,3,4,5
        while (left <= right) {
            if (sum + nums[right] <= 5) {
                sum += nums[right];
                    right--; //index 4}
                }
            if (left<=right&&sum + nums[left] <= 5) { //left<=right 이거 추가해야지 끝에 같은수 두번 들어가는거 방지한다.
                sum+=nums[left];
                left++; //index 4
            }
            if (sum==5||(sum+nums[left]>=5)||left>right){
                sum = 0;
                count++;
            }

        }
        return count;
    }
}
