package greedy_5;

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

        solution(nums1);
        solution(nums2);
        solution(nums3);




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
            left = right; // The codes above determines how far we can move to right while still covering the left index.
            //update left to the farthest position we reached(right)
            count++;
}
        System.out.println("count = " + count);
        System.out.println("right = " + right);
        System.out.println("left = " + left);
    }
}
