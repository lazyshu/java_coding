package 깊이우선탐색_6;

import java.util.Arrays;

/**
 * 못품 - 뺃김
 */
public class 알파코드_6 {
    public static void main(String[] args) {
        String s = "21114";
//        String s2 = "23251232";
//        String s3 = "21020132";
//        String s4 = "21350";
//        String s5 = "120225";
//        String s6 = "232012521";
        알파코드_6 sol = new 알파코드_6();
        System.out.println(sol.solution(s));
//        System.out.println(sol.solution(s2));
//        System.out.println(sol.solution(s3)==2);
//        System.out.println(sol.solution(s4)==0);
//        System.out.println(sol.solution(s5)==3);
//        System.out.println(sol.solution(s6)==12);
    }

    public int[] dy;

    public int solution(String s) {
        dy = new int[101]; ///?????
        return dfs(s,0);
    }

    public int dfs(String s, int index) { //5
//        21114
//        if () {
//            count++;
//            return;
//        }
        int num1 = Character.getNumericValue(s.charAt(index));
        if (num1 >= 1 && num1 <= 9) {
            dfs(s, index + 1);
        }
        if (index + 1 <s.length()) {
            int num2 = Integer.parseInt(s.substring(index, index + 2));

            if (num2 <= 26 && num2 >= 10) {
                dfs(s, index + 2);

            }

        }return 0;
    }
}
