package greedy_5;

import java.util.*;

//2025.1.24 30분
public class 타이타닉_1 {
    public static void main(String[] args) {
        int[] num1 = {90, 50, 70, 100, 60};
        int m1 = 140;
        int answer1=3;

        int[] num2 = {86, 95, 107, 67, 38, 49, 116, 22, 78, 53};
        int m2 = 150;
        int answer2=5;

        int[] num3 = {68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81};
        int m3 = 120;
        int answer3=14;

        System.out.println("answer1 = " + (answer1==mySolution(num1, m1)));
        System.out.println("answer2 = " + (answer2==mySolution(num2, m2)));
        System.out.println("answer3 = " + (answer3==mySolution(num3, m3)));

        System.out.println("answer1 = " + (answer1==solution(num1, m1)));
        System.out.println("answer2 = " + (answer2==solution(num2, m2)));
        System.out.println("answer3 = " + (answer3==solution(num3, m3)));

    }

    private static int solution(int[] num, int m) {
        //이건 그냥 int[]를 사용하고 인덱스를 left,right으로 사용했당..!
        //맞네 설명란에 두명밖에 못태운다고 했었징.. 햐.. 바부같은 나찡
        Arrays.sort(num);
        int left=0;
        int right= num.length-1;
        int count=0;
        while (left<=right) {
            if (num[left]+num[right]<=m) {
                count++;
                left++;
                right--;
                continue;
            }
            count++;
            right--;
        }


        return count;
    }

    private static int mySolution(int[] num, int m) {
        Arrays.sort(num);
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            li.add(num[i]);
        }
        int ans=0;
        int count=0;
        while (!li.isEmpty()){
            if (ans + li.getLast() < m) {
                ans += li.getLast();
                li.removeLast();
                continue;
            }
            if (ans + li.getFirst() <= m) {
                ans += li.getFirst();
                li.removeFirst();
                continue;
            }
            count++;
            ans=0;
        }
        if (ans > 0) {
            count++;
        }
        return count;
    }
}
