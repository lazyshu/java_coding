package 자료구조_3;

import java.time.LocalTime;

public class 피부과_4 {
    public static void main(String[] args) {
        int[] laser1 = {30, 20, 25, 15};
        String[] enter1 = {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"};
        System.out.println("Answer1 = " + solution(enter1,laser1));

        int[] laser2 = {30, 20, 25, 15};
        String[] enter2 = {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"};
        System.out.println("Answer2 = " + solution(enter2,laser2));

        int[] laser3 = {30, 20, 25, 15};
        String[] enter3 = {"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"};
        System.out.println("Answer3 = " + solution(enter3,laser3));



    }

    private static int solution(String[] enter, int[] laser) {
        int[] max = new int[enter.length];
        LocalTime previous_end_time = null;
        int previous_end_index = 0;
        LocalTime[][] inAndOut = new LocalTime[enter.length][2];
        for (int i = 0; i < enter.length; i++) {
            String[] time=enter[i].split(" ");
            inAndOut[i][0]=LocalTime.parse(time[0]);
            inAndOut[i][1]=LocalTime.parse(time[0]).plusMinutes(laser[Integer.parseInt(time[1])]);
            if (i==0) {
                previous_end_time=inAndOut[i][1];
                continue;
            }
            if (previous_end_time.isBefore(inAndOut[i][0])) {
                previous_end_time = inAndOut[i][1];
                previous_end_index = i;
                continue;
            }
            for (int j = previous_end_index; j < i; j++) {
                System.out.println(i+" compares previous index = "+j);
                if (inAndOut[j][1].isAfter(inAndOut[i][0])) {
                    max[j]++;
                    continue;
                }
                previous_end_index = j;
                previous_end_time = inAndOut[j][1];
            }
        }
        int answer=0;
        for (int max1 : max) {
            System.out.println("max1 = " + max1);
            answer = Math.max(answer, max1);
        }
        return answer;
    }
}
