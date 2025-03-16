package 깊이우선탐색_6;

import java.util.ArrayList;

public class 바둑대회_3 {
    /**
     * 못품.. 이행 안됨 :(
     */

    int n, answer;
    int[] ch;
    public static void main(String[] args) {
        int[][] nums = {{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}};
        바둑대회_3 sol = new 바둑대회_3();
        System.out.println("solution(nums) = " + sol.solution(nums));
    }

    public void DFS(int L, int s, int[][] cans) {
        if (L == n / 2) {
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (ch[i]==1) A.add(i);
                else B.add(i);
            }
            int Asum =0, Bsum=0;
            for (int i = 0; i < A.size(); i++) {
                Asum += cans[A.get(i)][0];
                Bsum += cans[B.get(i)][1];
            }
            answer = Math.min(answer, Math.abs((Asum - Bsum)));
        } else {
            for (int i = s; i < n; i++) {
                ch[i] = 1;
                DFS(L + 1, i + 1, cans);
                ch[i]=0;
            }
        }
    }

    public int solution(int[][] cans) {
        answer= 1000000000;
        n=cans.length;
        ch = new int[n];
        DFS(0, 0, cans);
        return answer;
    }
}
