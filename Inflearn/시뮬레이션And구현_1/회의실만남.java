package 시뮬레이션And구현_1;

import java.util.HashMap;
import java.util.Map;

public class 회의실만남 {
    public static void main(String[] args) {
        int[] enter = {1,2,5,3,4};
        int[] exit = {2,3,1,4,5};
        Map<Integer, Integer> enterMap = new HashMap<>();
        Map<Integer, Integer> exitMap = new HashMap<>();
        for (int i = 0; i < enter.length; i++) {
            enterMap.put(enter[i], i);
            exitMap.put(exit[i], i);
        }
        //answer 3,1,2,2
        int[] answer = new int[enter.length];
        for (int i = 0; i < enter.length; i++) {
            int count = 0;
            int inorder = enter[i] - 1;
            int indexFinder = 0;

            // enter[i]==1 , exist안에 1이있는 위치 반환.- 2
            int exitIndex = exitMap.get(enter[i]);

            for (int j = 0; j < exitIndex; j++) {
                int enterindex2 = enterMap.get(exit[j]);
                indexFinder = Math.max(enterindex2, indexFinder); //1
                System.out.println("indexFinder = " + indexFinder);
            }
            System.out.println("maxIndex = " + indexFinder);
            System.out.println("i = " + i);
            if (indexFinder > i) {
                count = indexFinder - i;
                answer[inorder] = count;
                continue;
            }
            if (indexFinder == 0) {
                count = i;
                answer[inorder] = count;
                continue;
            }

            System.out.println("count = " + count);

        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
