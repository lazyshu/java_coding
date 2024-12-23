package 시뮬레이션And구현_1;

public class 좌석번호 {
    public static void main(String[] args) {
        int c = 6;
        int r = 5;
        int k = 12;
        myMethod(r, c, k);
        int[] answer = actualAnswer(r, c, k);
        System.out.println("answer " + answer[0] + "," + answer[1]);
        /**
         * if (totalSeats == 0) {
         *                 answer = new int[]{0, 0};
         *                 break;
         *             }
         *             totalSeats--;
         * 난 이렇게 했는데 밑에 한줄이면 깔끔하당... 헷
         *
         * if (k>c*r)return new int[]{0,0};
         *
         */
    }

    private static void myMethod(int r, int c, int k) {
        int totalSeats = 6 * 5;
        //6,3
        boolean[][] seats = new boolean[r][c];
        int col = 0;
        int row = 0;
        int[] xRotate = {0, 1, 0, -1};
        int[] yRotate = {-1, 0, 1, 0};
        int direction = 1;
        int[] answer = new int[2];
        while (k > 0) {
            System.out.printf("row: %d%n", row + 1);
            System.out.printf("col: %d%n", col + 1);
            if (totalSeats == 0) {
                answer = new int[]{0, 0};
                break;
            }
            k--;
            totalSeats--;

            seats[row][col] = true;
            int rx = row + xRotate[direction];
            int cy = col + yRotate[direction];
            if (rx < 0 || cy < 0 || rx >= r || cy >= c || seats[rx][cy] == true) {
                direction = (direction + 1) % 4;
                rx = row + xRotate[direction];
                cy = col + yRotate[direction];
            }
            answer[1] = row + 1;
            answer[0] = col + 1;
            row = rx;
            col = cy;

        }
        System.out.println("answer " + answer[0] + "," + answer[1]);
    }

    private static int[] actualAnswer(int r, int c, int k) {
        int[] answer = new int[2];
        if (k > c * r) return new int[]{0, 0};
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while (count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }
}
