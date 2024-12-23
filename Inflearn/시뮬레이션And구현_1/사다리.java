package 시뮬레이션And구현_1;

public class 사다리 {
    public static void main(String[] args) {
//        int n=5;
//        int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
//       int[] answer = {'D', 'B', 'A', 'C', 'E'};

//        int n=7;
//        int[][] ladder = {{1, 3,5}, {1,3,6}, {2, 4}};
//        int[] answer = {'A', 'C', 'B', 'F', 'D','G','E'};

//        int n=8;
//        int[][] ladder = {{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}};
        // c,a,b,f,d,e,h,g

        int n=12;
        int[][] ladder = {{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}};
        //CAFBDIEKGLJH

        char alphabet = 'A';
        char[] answer = new char[n];
        int index=0;
        int pointer=1;
        //3 times
        while (index<n) {
            for (int i = 0; i < ladder.length; i++) {
                //2
                for (int j = 0; j < ladder[i].length; j++) {
                    if (ladder[i][j] == pointer) { //1
                        pointer++;
                        continue;
                    }
                    if (ladder[i][j]+1 == pointer) { //1
                        pointer--;
                        continue;
                    }

                }
            }
            answer[pointer-1] = alphabet++;
            index++;
            pointer=1+index;

        }
        System.out.println(answer);

    }

    public char[] actualAnswer(int n,int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }
        //첫번쨰 가로줄이 있는것들 swap한다.
        for (int[] line : ladder) {
            for (int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
        }
        return answer;
    }
}
