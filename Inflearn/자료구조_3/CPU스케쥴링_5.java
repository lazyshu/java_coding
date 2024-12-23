package 자료구조_3;

import java.util.*;

public class CPU스케쥴링_5 {
    /**
     *
     * 못품 :(
     */
    public static void main(String[] args) {
//        int[][] tasks_1 = {{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}};
//        int[] answer_1 = {1, 3, 0, 2, 4};
//        System.out.println("tasks_1 = " + Arrays.equals(answer_1, solution(tasks_1)));

        int[][] tasks_2 = {{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}};
        int[] answer_2 = {5, 4, 2, 0, 1, 3};
//        System.out.println("tasks_2 = " + Arrays.equals(answer_2, solution(tasks_2)));
        System.out.println("tasks_2 ActualAnswer = " + Arrays.equals(answer_2, actualSolution(tasks_2)));

//
//        int[][] tasks_3 = {{1,2}, {2,3}, {1,3}, {3,3}, {8,2},{1,5},{2,2},{1,1}};
//        int[] answer_3 = {7,0,6,1,4,2,3,5};
//        System.out.println("tasks_3 = " + Arrays.equals(answer_3, solution(tasks_3)));
//
//        int[][] tasks_4 = {{999,1000},{996,1000},{998,1000},{999,7}};
//        int[] answer_4 = {1,3,0,2};
//        System.out.println("tasks_4 = " + Arrays.equals(answer_4, solution(tasks_4)));
    }

    private static int[] actualSolution(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        //우옹?
        LinkedList<int[]> programs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //우오오옹?!
            programs.add(new int[]{tasks[i][0], tasks[i][1],i});
            System.out.println("programs = " + Arrays.toString(programs.getLast()));
        }



        programs.sort((a,b)->a[0]-b[0]);
        //시작 시간은 순서대로 정렬해준다.
        for (int[] program : programs) {
            System.out.println("Arrays.toString(program = " + Arrays.toString(program));
//            Arrays.toString(program = [1, 3, 2]
//            Arrays.toString(program = [1, 5, 3]
//            Arrays.toString(program = [1, 1, 5]
//            Arrays.toString(program = [2, 2, 4]
//            Arrays.toString(program = [5, 2, 0]
//            Arrays.toString(program = [7, 3, 1]
        }

        //요건 실행시간을 정렬해주나봐!
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int fT=0; //모꼬
        int index=0;

        while (!programs.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()){
                fT = Math.max(fT, programs.peek()[0]);
                //요건 뭘꼬
            }
            while (!programs.isEmpty() && programs.peek()[0] <= fT) {
                System.out.println("programs = " + programs.peek()[0]);
                System.out.println("fT = " + fT);
                int[] x = programs.pollFirst();
                System.out.println("x[0]+ \", \"+x[1] = " + x[0]+ ", "+x[1]);
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            answer[index++] = ex[1];
        }
        return answer;
    }

//    private static int[] solution(int[][] tasks) {
//        TreeMap<Integer, TreeMap<Integer, Integer>> tm = new TreeMap<>();
//        for (int i = 0; i < tasks.length; i++) {
//            int start = tasks[i][0];
//            int takes = tasks[i][1];
//            tm.putIfAbsent(start, new TreeMap<>());
//            tm.get(start).putIfAbsent(takes, i);
//        }
//        System.out.println("Arrays.toString(new TreeMap[]{tm}) = " + Arrays.toString(new TreeMap[]{tm}));
//        int[] answer = new int[tasks.length];
//        Map.Entry<Integer, Integer> firstEntry = tm.firstEntry().getValue().pollFirstEntry();
//        int index = 0;
//        answer[index++] = firstEntry.getValue();
//        int time = firstEntry.getValue() + firstEntry.getKey();
//        System.out.println("time = " + time);
//        System.out.println("Arrays.toString(index = " + Arrays.toString(answer));
//        System.out.println("Arrays.toString(new TreeMap[]{tm}) = " + Arrays.toString(new TreeMap[]{tm}));
////        while (tm.size() > 0) {
////            if (tm.firstKey() == time) {
////                time = tm.firstEntry().getValue().pollFirstEntry().getValue();
////                answer[index++] = time;
////                continue;
////            }
////            if ()
////            System.out.println("meep = " + meep);
////        }
//        return new int[]{1, 2};
//    }
}
