package 해싱And시간파싱_2;

public class 같은빈도수만들기 {
    public static void main(String[] args) {
        String input = "abbccddee";
        int[] addup = new int[5];
        int max=0;
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i)-97;
            addup[index] += 1;
            if (max < addup[index]) {
                max = addup[index];
            }
        }
        int[] answer = new int[5];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = max - addup[i];
            System.out.println("answer = " + answer[i]);
        }
    }
}
