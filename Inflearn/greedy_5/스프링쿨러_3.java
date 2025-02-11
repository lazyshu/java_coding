package greedy_5;

import java.util.Arrays;

public class 스프링쿨러_3 {
    public static void main(String[] args) {
        int n1 = 8;
        int[] nums1 = {1, 1, 1, 2, 1, 1, 2, 1, 1};
        int answer1 = 3;


        int n2 = 4;
        int[] nums2 = {1, 2, 2, 0, 0}; //0,1,2,3,4
        int answer2 = 1;

        int n3 = 11;
        int[] nums3 = {1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1};
        int answer3 = 3;

        int n4 = 5;
        int[] nums4 = {1, 0,0,0, 1};
        int answer4 = -1;

        solution(nums1);
        solution(nums2);
        solution(nums3);
        solution(nums4);


        System.out.println("actualSolution(nums1) = " + actualSolution(nums1));
        System.out.println("actualSolution(nums2) = " + actualSolution(nums2));
        System.out.println("actualSolution(nums3) = " + actualSolution(nums3));
        System.out.println("actualSolution(nums4) = " + actualSolution(nums4));


    }
//    int[] nums2 = {1, 2, 2, 0, 0}; //0,1,2,3,4
    private static int actualSolution(int[] nums) {
        int count=0;
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = Math.max(0, i - nums[i]); //left
            arr[i][1] = Math.min(nums.length-1, i + nums[i]); //right
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]); //왼쪽 범위를 기준으로 정렬..

        int start=0,end=0,i=0;
        while (i < arr.length) {
            while (i < arr.length && arr[i][0] <= start) {
                end = Math.max(end, arr[i][1]);
                i++;
            }
            count++;
            if (end >= arr.length-1) {
                return count;
            }
            if (start == end) {
                return -1;
            }

            start=end;
        }
        return count;
    }

    private static void solution(int[] nums) {
        int left=0, right=0;
        int count=0;
        while (right < nums.length-1) { //keep iterating until the right index reaches to the last index.
            for (int i = left; i < nums.length; i++) { // i==left, starting from left.
                if (nums[i] >= i - left) { // if current sprinkler can water on the left index.
                    if (right < nums[i] + i) { //if current index can sprinkle extend further than right index.
                        right = nums[i] + i; //we move the right index.
                        System.out.println(right);

                        if (right >= nums.length-1) {
                            break; //if the right index reaches or exceeds the end of array. we stop so following code won't execute
                        }
                    }
                }
            }
        if (left == right) {
            count=-1;
            break;
        }
            left = right; // The codes above determines how far we can move to right while still covering the left index.
            //update left to the farthest position we reached(right)
            count++;
}
        System.out.println("count = " + count);
        System.out.println("right = " + right);
        System.out.println("left = " + left);
    }
}
