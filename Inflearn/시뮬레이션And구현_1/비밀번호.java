package 시뮬레이션And구현_1;

import java.util.ArrayList;
import java.util.List;

public class 비밀번호 {
    public static void main(String[] args) {
        int[] keypad = {1, 5, 7, 3, 2, 8, 9, 4, 6};
        String password = "63855522226592";

        int count = 0;
        char[] pw = password.toCharArray();
        int[][] keys = new int[3][3];
        int index = 0;
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                li.add(new ArrayList<>());
                li.get(i).add(keypad[index]);
                index++;
            }
        }


        index = 0;
        while (pw.length - 1 > index) {
            System.out.println("count = " + count);
            int col = 0;
            int row = 0;
            int intPw = 0;
            for (int i = 0; i < 3; i++) {
                intPw = Integer.parseInt(String.valueOf(pw[index]));
                col = li.get(i).indexOf(intPw);
                if (col >= 0) {
                    System.out.println("intPw = " + intPw);
                    row = i;
                    break;
                }
            }
            System.out.println("row = " + row);
            System.out.println("col = " + col);

            if (row == 1 && col == 1) {
                count++;
                index++;
                continue;
            }
            int nextPw = Integer.parseInt(String.valueOf(pw[index + 1]));

            if (nextPw == intPw) {
                index++;
                continue;
            }

            int outOfLoop = 0;
            for (int k = (Math.max(row - 1, 0)); k < (Math.min(row + 2, 3)); k++) {
                for (int l = Math.max(col - 1, 0); l < (Math.min(col + 2, 3)); l++) {
                    if (li.get(k).get(l) == nextPw) {
                        //비밀번호 첫글자의 이웃이면 실행된다
                        count++;
                        index++;
                        outOfLoop++;
                        System.out.println("meep = " + count);
                        break;
                    }
                }
                if (outOfLoop > 0) {
                    break;
                }
            }
            if (outOfLoop == 0) {
                count += 2;
                index++;
            }

        }
        System.out.println("count = " + count);
        System.out.println("li = " + li.get(1).indexOf(1));

    }
}
