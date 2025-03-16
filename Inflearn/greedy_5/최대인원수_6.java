package greedy_5;

import javax.swing.plaf.IconUIResource;
import java.util.*;

/**
 * 어려워서 실패! :(
 */

public class 최대인원수_6 {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] trains1 = {{1, 4, 2,}, {2, 5, 1}};
        int[][] bookings1 = {{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}};
        int answer1 = 5;
        solution(n1, trains1, bookings1);

        int n2 = 5;
        int[][] trains2 = {{2, 3, 1}, {1, 5, 1}};
        int[][] bookings2 = {{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}};
        int answer2 = 2;

        int n3 = 8;
        int[][] trains3 = {{1, 8, 3}, {3, 8, 1}};
        int[][] bookings3 = {{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}};
        int answer3 = 7;

        int n4 = 9;
        int[][] trains4 = {{1, 8, 3}, {3, 9, 2}, {1, 5, 3}};
        int[][] bookings4 = {{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}};
        int answer4 = 8;

        int n5 = 9;
        int[][] trains5 = {{2, 7, 2}, {3, 9, 2}, {1, 5, 3}};
        int[][] bookings5 = {{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}};
        int answer5 = 7;


    }

    private static void solution(int n, int[][] trains, int[][] bookings) {
//        int n1=5;
//        int[][] trains1={{1,4,2,},{2,5,1}}; int[i][2] seats
//        int[][] bookings1 = {{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));
        Collections.addAll(queue, bookings);


        trains = Arrays.stream(trains).sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);
        System.out.println("trains = " + Arrays.deepToString(trains));

        int count = 0;

        for (int i = 0; i < trains.length; i++) {
            PriorityQueue<int[]> seats = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

            //seat에 train 시간 넣어두기 seat[0]=[1][4], seats[1]=[1][4]
            for (int j = 1; j < trains[i][2]; j++) {
                int[] train = {trains[i][0], trains[i][1]};
                seats.add(train);
            }
            for (int[] seat : seats) {
                System.out.println("---seat = " + Arrays.toString(seat));
            }


            while (!queue.isEmpty() || !seats.isEmpty()) {
                int[] bookingQueue = queue.poll();
                int[] seat = seats.poll();
                //booking에 [1,2] 순서대로 꺼내서 seat에 자리 맞춰 보기!
                System.out.println("seat = " + Arrays.toString(seat));

                //기차 시작 시간이 예약 시작 시간과 같거나 커야한다 기차끝나는 시간이 예약 시간보다 커야한다.
                if (bookingQueue[0] < seat[1] && bookingQueue[0] >= seat[0]) {
                    //seat-1,4

                    //환승해야할때 다시 큐 앞에 넣어둔다.
                    if (bookingQueue[1] > seat[1]) {
                        int leftover = bookingQueue[1] - seat[1];
                        int[] leftoverTime = {seat[1], leftover};
                        queue.offer(leftoverTime); //정렬되서 들어간당!! 굿
                        continue;
                    }

                    count++;
                    //예약시간이 기차끝나는 시간일 경우 count++하고 다음 seat[j++]올린다.
                    if (bookingQueue[1] == seat[1]) {
                        continue;
                    }
                    //예약시간을 빼고도 자리가 더 남을 경우

                    System.out.println("예약시간을 빼고도 자리 남음.");
                    seat[0] = bookingQueue[1];
                    seats.offer(seat);
                }
                break;

            }

        }
        System.out.println("count = " + count);
    }


}

