package 시뮬레이션And구현_1;

public class 청소로봇 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        int k=10;
//        int[][] room = {
//                {0, 0, 1, 0,0},
//                {0, 1, 0, 0,0},
//                {0, 0, 0, 0, 0},
//                {1,0, 0, 0, 1},
//                {0, 0, 0, 0, 0}
//        };
//        int k=25;
//        int[][] room = {
//                {0, 0, 0, 1,0, 1},
//                {0, 0, 0, 0, 0,0},
//                {0, 0, 0, 0, 0,1},
//                {1,1, 0, 0, 1,0},
//                {0, 0, 0, 0, 0,0},
//                {0, 0, 0, 0, 0,0}
//        };
//        int k=20;
        int[] answer=direction(board, k);
        System.out.println("answer = " + answer[0]+ ","+answer[1]);

    }

    private static int[] direction(int[][] board, int k) {
        /**
         * 다음에 board[row][col] == 1 으로 되기않게 다시 코딩해보기 방해물 위로 갔다가 다시 돌아가지 않기 :(
         */
        int seconds=0;
        int row=0;
        int col=0;
        int direction=0;
        //스케일님이 if문보다 switch문이 더 좋다고 알려주셨징 https://aahc.tistory.com/6
        //Switch 문은 컴파일러가 점프 테이블이나 바이너리 서치로 최적화할 수 있어, 특정 조건에서 if 문보다 최대 3배 이상 빠를 수 있다.
        while (k > seconds) {
            if (board[row][col] == 1) {
                switch (direction) {
                    case 0:
                        if (board[row+1][col-1]==1){
                            direction=2;
                            col--;
                        }else {
                            direction=1;
                            col--;
                            row++;
                        }
                        break;
                    case 1:
                        direction=2;
                        row--;
                        col--;
                        break;
                    case 2:
                        direction=3;
                        col++;
                        row++;
                        break;
                    case 3:
                        direction=0;
                        row++;
                        col++;
                        break;
                }
                seconds++;
            }
            switch (direction) {
                case 0:
                    seconds++;
                    if (board[row].length -1== col) {
                        direction=1;
                    }else{ col++;}
                    break;
                case 1:
                    seconds++;
                    if (board.length -1== row) {
                        direction=2;
                    }else {
                        row++;
                    }
                    break;
                case 2:
                    seconds++;
                    if (0 == col) {
                        direction=3;
                    }else{
                        col--;
                    }
                    break;
                case 3:
                    seconds++;
                    if (0 == row) {
                        direction=0;
                    }
                    row--;
                    break;
            }
        }
        return new int[]{row, col};
    }

    private static int[] actualAnswer(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x =0,y =0,d =1,count =0;
        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d= (d+1)%4; //이게 4넘으면 다시 1로 돌아오는 계산법이라고 함 @.@
                continue;
            }
            x=nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

}
