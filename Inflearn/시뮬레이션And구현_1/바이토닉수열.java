package 시뮬레이션And구현_1;

import java.util.ArrayList;

public class 바이토닉수열 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 2, 5, 1};
        //answer:5
//        int[] arr = {1, 1, 2, 3, 5, 7, 4, 3, 1, 2};
        //ar:8
//        int[] arr = {3, 2, 1, 3, 2, 4, 6, 7, 3, 1};
        //an:6
//        int[] arr = {1, 3, 1, 2, 1, 5, 3, 2, 1, 1};
        //answer:5
        int answer = myMethod(arr);
        System.out.println("My answer = " + answer);

        int actualAnswer = actualAnswer(arr);
        System.out.println("actualAnswer = " + actualAnswer);
    }


    private static int myMethod(int[] arr) {
        int max = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (!flag) {
                    if (arr[j - 1] < arr[j]) {
                        count++;
//                        System.out.println("arr = " + arr[j]);
                        continue;
                    }
                    if (count == 0) {
                        break;
                    }
//                    System.out.println("arr = " + arr[j]);
                    flag = true;
                    count++;
                    continue;
                }

                if (arr[j - 1] > arr[j]) {
                    count++;
                    System.out.println("arr = -" + arr[j]);
                    continue;
                }
                if (arr[j - 1] < arr[j]) {
                    break;
                }
            }
//            System.out.println("count = " + count);
//            System.out.println("flag = " + flag);
            max = Math.max(max, count);
            count = 0;
            flag = false;
        }
        return ++max;
//        System.out.println("max = " + ++max);
    }

    private static int actualAnswer(int[] arr) {
        int answer = 0;
        int n = arr.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
//        int[] arr = {1, 3, 2, 5, 7, 4, 2, 5, 1};
                peaks.add(i);  //3,7,5
            }
        }
        for (int x : peaks) {
            int left = x;
            int right = x;
            int cnt = 1;
            while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
                left--;
                cnt++;
            }
            while ((right + 1 < arr.length && arr[right + 1] < arr[right])) {
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
