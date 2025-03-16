package 깊이우선탐색_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//머리가 안돌아간다요 블루베리랑 요거트 다시 먹어야지 ㅠㅠㅠㅠ 왜이램
//정답 뻇겨야징
public class IP주소_5 {
    public static LinkedList<String> tmp;
    public static ArrayList<String> res;

    public static void main(String[] args) {
        String number = "2025505";
        solution(number);
        for (String re : res) {
            System.out.println("re = " + re);
        }

    }


    private static void solution(String number) {
        IP주소_5 ip = new IP주소_5();
        tmp = new LinkedList<>();
        res = new ArrayList<>();

        dfs(number,0);

    }

    //    2025505
    //"20.25.50.5","20.255.0.5","202.5.50.5","202.55.0.5"

    private static void dfs(String number, int index) {// 7
        if (tmp.size() ==4&& index == number.length()) {
            String Ts = "";
            for (String x : tmp) {
                Ts += x + ".";
            }
            res.add(Ts.substring(0, Ts.length() - 1));
        }
        else {
            for (int i = index; i < number.length(); i++) {
                if (number.charAt(index)=='0'&&i>index) return;
                String num = number.substring(index, i + 1);
                if (Integer.parseInt(num)>255) return;
                tmp.add(num);
                dfs(number, i + 1);
                tmp.pollLast();
            }
        }

    }
}
