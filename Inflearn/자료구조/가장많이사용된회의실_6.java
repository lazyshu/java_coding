package 자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 가장많이사용된회의실_6 {
    public static void main(String[] args) {
        int n_1 = 2;
        int[][] meetings = {{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};
        int answer_1 = 0;
        System.out.println("answer_1 = " + (answer_1 == solution(n_1, meetings)));

        int n_2 = 3;
        int[][] meetings2 = {{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};
        int answer_2 = 0;
        System.out.println("answer_2 = " + (answer_2 == solution(n_2, meetings2)));

        int n_3=3;
        int[][] meetings3 = {{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}};
        int answer_3 = 1;
        System.out.println("answer_3 = " + (answer_3 == solution(n_3, meetings3)));

        int n_4=4;
        int[][] meetings4 = {{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};
        int answer_4 = 2;
        System.out.println("answer_4 = " + (answer_4 == solution(n_4, meetings4)));
    }

    private static int solution(int n, int[][] meetings) {
        TreeMap<Integer, List<Integer>> meetingSchedule = new TreeMap<>();
        for (int i = 0; i < meetings.length; i++) {
            meetingSchedule.putIfAbsent(meetings[i][0], new ArrayList<>());
            meetingSchedule.get(meetings[i][0]).add(meetings[i][1]);
        }
        Integer[][] meetingRooms = new Integer[n][2];
        for (int j = 0; j < meetingRooms.length; j++) {
            Map.Entry<Integer, List<Integer>> entry = meetingSchedule.firstEntry();
            meetingRooms[j][0] = entry.getValue().getFirst();
            meetingRooms[j][1] = 1;
            if (entry.getValue().size() > 1) {
                meetingSchedule.firstEntry().getValue().remove(entry.getValue().getFirst());
                continue;
            }
            meetingSchedule.remove(entry.getKey());
        }


        while (!meetingSchedule.isEmpty()){
            int min = meetingRooms[0][0];
            int minIndex = 0;
            for (int j = 1; j < meetingRooms.length; j++) {
                if (min > meetingRooms[j][0]) {
                    minIndex = j;
                    min = meetingRooms[j][0];
                }
            }

            Map.Entry<Integer, List<Integer>> entry = meetingSchedule.firstEntry();
            meetingRooms[minIndex][0] +=  entry.getValue().getFirst()-entry.getKey();
            meetingRooms[minIndex][1]++;
            if (entry.getValue().size() > 1) {
                meetingSchedule.firstEntry().getValue().remove(entry.getValue().getFirst());
                continue;
            }
            meetingSchedule.remove(entry.getKey());
        }


        int max = meetingRooms[0][1];
        int maxIndex = 0;
        for (int i = 0; i < meetingRooms.length; i++) {
//            System.out.println("meetingRooms = " + meetingRooms[i][1]);
            if (max < meetingRooms[i][1]) {
                max = meetingRooms[i][1];
                maxIndex = i;
            }
        }

//        System.out.println("maxIndex = " + maxIndex);
        return maxIndex;
    }

}
