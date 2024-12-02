package 시뮬레이션And구현;

public class 잃어버린_강아지_답 {
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
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
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

        int d1 = 0, d2 = 0, count = 0;
        while (count < 10000) {
            count++;
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];
            if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
                d1 = (d1 + 1) % 4;
            }else {
                // 이동
                x1 = nx1;
                y1 = ny1;
            }
            if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
                d2 = (d2 + 1) % 4;
            }else {
                // 이동
                x2 = nx2;
                y2 = ny2;
            }
            if (x1 == x2 && y1 == y2) break;
        }
        if (count >= 10000) count= 0;
        System.out.println(count);
    }
}
