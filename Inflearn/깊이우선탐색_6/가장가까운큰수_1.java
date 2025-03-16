//package 깊이우선탐색_6;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//public class 가장가까운큰수_1 {
//    public static void main(String[] args) {
//        int n1 = 123;
//        int answer1=132;
//        System.out.println("solution(n1) = " + (solution(n1)==answer1));
//    }
//
//    private static int solution(int n) {
//        String st = String.valueOf(n);
//        char[] ch = st.toCharArray();
//
//
//        //321
//        for (int i = ch.length-2; i >=0 ; i++) {
//            if (ch[i] < ch[i + 1]) {
//                char[] sort = Arrays.copyOfRange(ch,i,ch.length);
//                System.out.println("sort = " + Arrays.toString(sort));
//                Arrays.sort(Comparator.reverseOrder(sort));
//                System.out.println("ch = " + Arrays.toString(sort));
//            }
//        }
//    return -1;}
//}
