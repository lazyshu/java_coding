package 시뮬레이션And구현;

import java.util.ArrayList;
import java.util.List;

public class 추악한과일바구니 {
    public static void main(String[] args) {
        int[][] fruit = {
                {10, 20, 30},
                {12, 15, 20},
                {20, 12, 15},
                {15, 20, 10},
                {10, 15, 10}
        };

    }
    public static int TotalFruit(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if(ch[i]==1)continue;
            if(isMinUnique(fruit[i])==false)continue; //작은 수가 하나일가 아닐떄 continue;
            for (int j = i+1; j <n; j++) {
                if (ch[j]==1) continue;
                if(isMinUnique(fruit[j])==false)continue;
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]--;
                        fruit[j][b]++;
                        ch[i]=1;
                        ch[j]=1;
                        break;

                    }
                }
            }

        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }

    private static int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < 3; i++) {
            if (fruit[i]==min) return i;
        }
        return 0;
    }

    private static boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if (x==min) cnt++;
        }
        return cnt==1;
    }

    private static int getMin(int[] fruit) {
        int min = 100;
        for (int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }
}
