package 깊이우선탐색_6;

import java.util.Stack;
import java.util.stream.LongStream;

public class 줄다리기_2 {
    //못품 :( 답 봐도 실행하면 이상한 결과 >:(

    int[] ch;
    int[][] relation;
    int answer;
    Stack<Integer> pm;

    public static void main(String[] args) {

        int num = 7;
        int[][] nums_1 = {{1, 3}, {5, 7}, {4, 2}};
        줄다리기_2 obj = new 줄다리기_2();
        System.out.println("actualSolution(nums_1) = " + actualSolution(obj,num,nums_1));
        int[][] num_2 = {{3, 2}, {3, 5}, {5, 2}, {7, 3}};

    }

    public static long actualSolution(줄다리기_2 obj,int num,int[][] nums) {
        obj.ch =new int[8];
        obj.relation=new int[8][8];
        obj.answer=0;
        obj.pm = new Stack<>();
        for (int[] x : nums) {
            obj.relation[x[0]][x[1]]=1;
            obj.relation[x[1]][x[0]]=1;
        }
        obj.Dfs(0);
        return obj.answer;
    }

    public void Dfs(int num) {
        if (num==7) {
            answer++;
        } else {
            for (int i = 0; i < 8; i++) {
                if (!pm.empty()&&relation[pm.peek()][i]==1) continue;
                if (ch[i] == 0) {
                    ch[i]=1;
                    pm.push(i);
                    Dfs(num + 1);
                    ch[i]=0;
                    pm.pop();
                }
            }
        }
    }

}
