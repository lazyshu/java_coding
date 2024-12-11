package 해싱And시간파싱;

import java.util.HashMap;

public class 음수가있는부분수열 {
    public static void main(String[] args) {
        int[] input = {-1, 0, 1};
        int m = 0;
        int count=0;
        for (int i = 0; i < input.length; i++) {
            int sum=0;
            for (int j = i; j < input.length; j++) {
                sum += input[j];
                if (sum == m) {
                    count++;
                }
            }
        }
//        System.out.println("count = " + count);
        int actualAnswer = actualAnswer(input, m);
        System.out.println("actualAnswer = " + actualAnswer);
    }

    private static int actualAnswer(int[] input, int m) {
       int answer=0;
       int sum=0;
        HashMap<Integer, Integer> hm = new HashMap<>(); //input[i], num(요게 중요하당)+1씩 증가해서 answer에 넣는다
        hm.put(0, 1); //요건 왜 넣어주지
        for (int i : input) {
            sum += i;
            if (hm.containsKey(sum - m)) { //sum,m이 둘다 영이면! 한개 추가 되겠넴!!
                answer+= hm.get(sum-m);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return answer;
    }

}
