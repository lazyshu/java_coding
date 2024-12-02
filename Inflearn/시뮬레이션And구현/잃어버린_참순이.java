package 시뮬레이션And구현;

import java.util.Arrays;

public class 잃어버린_참순이 {
    /**
     *
     *안된당 :(
     */
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };
//        int[][] positions = findPositions(board);
//        int[] dog=findDogPosition(positions);
//        int[] hyunsoo = findHyunPosition(positions);


        int answer = findEachother(board);
        System.out.println(answer);
    }

    private static int findEachother(int[][] board) {

        int min = 0; // 시간 경과
        int n = board.length;
        int x1=0,x2=0,y1=0,y2=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }

        }
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향
        int[] dy = {0, 1, 0, -1};
        int dogIndex = 1; // 강아지 초기 방향 (오른쪽)
        int hyunIndex = 1; // 현수 초기 방향 (오른쪽)

        while (min < 10000) {
            // 강아지와 현수 만남 체크
            if (x1 == y1 && x2 == y2) {
                return min; // 만났을 때 시간 반환
            }

            min++; // 시간 증가

            // 강아지 이동
            int nextDogX = x1 + dx[dogIndex];
            int nextDogY =y1 + dy[dogIndex];

            if (nextDogX < 0 || nextDogY < 0 || nextDogX >= n || nextDogY >= n || board[nextDogX][nextDogY] == 1) {
                // 벽에 부딪히면 방향 전환
                dogIndex = (dogIndex + 1) % 4;
            } else {
                // 이동
                x1 = nextDogX;
                y1 = nextDogY;
            }

            // 현수 이동
            int nextHyunX = x2 + dx[hyunIndex];
            int nextHyunY = y2 + dy[hyunIndex];

            if (nextHyunX < 0 || nextHyunY < 0 || nextHyunX >= n || nextHyunY >= n || board[nextHyunX][nextHyunY] == 1) {
                // 벽에 부딪히면 방향 전환
                hyunIndex = (hyunIndex + 1) % 4;
            } else {
                // 이동
                x2= nextHyunX;
                y2 = nextHyunY;
            }

            // 강아지와 현수 만남 체크 (이동 후)
            if (x1 == x2 && y1 == y2) {
                return min; // 만났을 때 시간 반환
            }
        }

        // 제한 시간 초과 시 0 반환
        return 0;
    }


//    private static int findEachother(int[][] board, int[] dog, int[] hyunsoo) {
//        int min=0;
//        int n = board.length;
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        int dogIndex=1;
//        int hyunIndex=1;
//        while (min < 10000) {
//            if (hyunsoo[0]==dog[0]&&hyunsoo[1]==dog[1]) {
//                return min;
//            }
//            min++;
//            int dognx = dog[0] + dx[dogIndex]; //오른쪽 0
//            int dogny = dog[1] + dy[dogIndex]; //오른쪽 1
//
//            int hyunNx = hyunsoo[0] + dx[hyunIndex];
//            int hyunNy = hyunsoo[1] + dy[hyunIndex];
//            System.out.println("dog: "+dog[0]+","+dog[1]+" index:"+dogIndex);
//            System.out.println("현수: "+hyunsoo[0]+","+hyunsoo[1]+" index:"+hyunIndex);
//            System.out.println("시간: "+min);
//            if (dognx<0||dogny<0||dognx>=n||dogny>=n||board[dognx][dogny] == 1) {
//                dogIndex = (dogIndex + 1) % 4;
//            } else {
//                dog[0] = dognx;
//                dog[1] = dogny;
//            }
//            if (hyunNx>=n||hyunNy>=n||hyunNx<0||hyunNy<0||board[hyunNx][hyunNy] == 1) {
//                hyunIndex = (hyunIndex + 1) % 4;
//            } else {
//                hyunsoo[0] = hyunNx;
//                hyunsoo[1] = hyunNy;
//            }
//            if (dog[0] == hyunsoo[0] && dog[1] == hyunsoo[1]) {
//                return min; // 만났을 때 시간을 반환
//            }
//
//        }
//
//        return 0;
//    }

    private static int[] findHyunPosition(int[][] positions) {
        return new int[]{positions[0][0], positions[0][1]};
    }

    private static int[] findDogPosition(int[][] positions) {
        return new int[]{positions[1][0], positions[1][1]};
    }

    private static int[][] findPositions(int[][] board) {
        int check=0; //2개면 멈춘다, 현수랑 강아지 위치 다찾음
        int[][] position = new int[2][2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]){
                    case 2:
                        position[0][0]=i;
                        position[0][1] = j;
                        check++;
                        break;
                    case 3:
                        position[1][0] = i;
                        position[1][1] = j;
                        check++;
                        break;
                    default:
                        if(check>=2){
                            break;
                        }

                }
            }if (check>=2)break;
    }
        return position;
    }
}
