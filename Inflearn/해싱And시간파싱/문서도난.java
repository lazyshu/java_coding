package 해싱And시간파싱;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.TreeMap;

public class 문서도난 {
    //자동으로 시간 순서대로 정렬되게 넣으려면 TreeMap을 사용하자! >_<b
    public static void main(String[] args) {
        String[] input = {"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"};
        String times = "08:33 09:45";
        String[] answer = solution(input, times);
        System.out.println("answer = " + Arrays.toString(answer));


    }

    private static String[] solution(String[] input, String times) {
        LocalTime begin = LocalTime.parse(times.substring(0, 5));
        LocalTime end = LocalTime.parse(times.substring(6));
        TreeMap<LocalTime, String> employees = new TreeMap<>();
        for (String string : input) {
            LocalTime enteredAt = LocalTime.parse(string.substring(string.length() - 5));
            if (begin.isBefore(enteredAt.plusMinutes(1)) && end.isAfter(enteredAt.minusMinutes(1))) {
                employees.put(enteredAt, string.substring(0, string.length() - 5));
            }
        }
        return employees.values().toArray(new String[0]);
    }
}
