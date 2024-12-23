package 해싱And시간파싱_2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class 경고메일 {
    public static void main(String[] args) {
        String[] reports = {"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"};
        int time = 60;

        String[] answer = getSolution(reports, time);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    private static String[] getSolution(String[] reports, int time) {
        HashMap<String, LocalTime> reportsEnteredAt = new HashMap<>();
        HashMap<String, Long> amountOfTimeSpent = new HashMap<>();
        Set<String> answer = new HashSet<>();

        for (String report : reports) {
            String[] split = report.split(" ");
            if (split[2].equals("in")) {
                reportsEnteredAt.put(split[0], LocalTime.parse(split[1]));

                continue;
            }
            LocalTime enteredAt = reportsEnteredAt.get(split[0]);
            Duration duration = Duration.between(enteredAt, LocalTime.parse(split[1]));
            amountOfTimeSpent.put(split[0], amountOfTimeSpent.getOrDefault(split[0], 0L) + duration.toMinutes());
            Long timeSpent = amountOfTimeSpent.get(split[0]);
            if (timeSpent > time) {
                answer.add(split[0]);
            }
        }

        String[] answerInString = answer.toArray(new String[0]);
        Arrays.sort(answerInString);
        return answerInString;
    }
}
