package 자료구조;

public class 곂쳐진압축해제_2 {
    public static void main(String[] args) {
        String input_1 = "3(a2(b))ef";
        String actualAnswer1 = "abbabbabbef";
        System.out.println("solution for input_1: "+actualAnswer1.equals(decodedString(input_1)));

        String input_2 = "2(ab)k3(bc)";
        String actaulAnser2 = "ababkbcbcbc";
        System.out.println("solution for input_2: "+actaulAnser2.equals(decodedString(input_2)));


        String input_3 = "2(ab3((cd)))";
        String actualAnswer3 = "abcdcdcdabcdcdcd";
        System.out.println("solution for input_3: "+actualAnswer3.equals(decodedString(input_3)));

        String input_4 = "2(2(ab)3(2(ac)))";
        String actaulAnswer4 = "ababacacacacacacababacacacacacac";
        System.out.println("solution for input_4: "+actaulAnswer4.equals(decodedString(input_4)));

        String input_5 = "3(ab2(sg))";
        String actualAnswer5 = "absgsgabsgsgabsgsg";
        System.out.println("solution for input_5: "+actualAnswer5.equals(decodedString(input_5)));
    }

    private static String decodedString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        if (input.charAt(0) == '(') {
            return input.substring(1, input.length() - 1);
        }
        if (input.charAt(0)>='a'&&input.charAt(0)<='z') {
            return input.charAt(0)+decodedString(input.substring(1));
        }
        int i=0;
        int num=0;
        while (9 >= (input.charAt(i) - '0') && (input.charAt(i) - '0') >= 0) {
            i++;
        }


        num = Integer.parseInt(input.substring(0, i));
        input = input.substring(i);
        String st = "";
        int bracket=0;
        i=0;
        while (i<input.length()) {
            String letter= String.valueOf(input.charAt(i));

            if (letter.equals("(")) {
                
                bracket++;
                i++;
                continue;
            }
            if ((bracket == 1) && input.charAt(i)>='a'&&input.charAt(i)<='z') {
                st += letter;
            }
            if (letter.equals(")")) {
                if (bracket == 1) {
                    if (input.length()==st.length()+2) {
                        break;
                    }

                    st += decodedString(input.substring(st.length()+1,i));

                        break;
                }
                bracket--;
            }
            i++;
        }
        return st.repeat(num)+decodedString(input.substring(i+1));
//        if (i -1== input.length()) {
//            System.out.println("여기서 오류인가");
//            return st.repeat(num);
//        }
//        System.out.println("decodedString(input.substring(i) = " +decodedString(input.substring(i)));
//        return st.repeat(num) + decodedString(input.substring(i+1));
    }
}
