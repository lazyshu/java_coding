package sortingAndThinking_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모임장소_5 {
    public static void main(String[] args) {
        int[][] board = {{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int answer = 8;
        System.out.print("answer==solution(board) = " + (answer==solution(board)));
    }

        public static int solution(int[][] board) {
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            int answer=0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 1) {
                        col.add(j);
                        row.add(i);
                    }
                }
            }
            col.sort((a,b)->a-b); //row는 순서되로 이미 저장되서 소팅할 필요 없음
            int row_center = row.get(row.size() / 2);
            int col_center = col.get(col.size() / 2);

            for (Integer i : col) {
                answer += Math.abs(i - col_center);
            }
            for (Integer i : row) {
                answer += Math.abs(i - row_center);
            }
            System.out.println("answer = " + answer);
            return answer;
        }
    }
