package 넓이우선탐색BFS_7;

/**
 * 도착하는걸 넘기기만 하는줄 알고 코드 짰는데 그게 아니라 딱 도착지점에 와야했다.. 지피티가 대신 짜줌
 *
 * 정답은 bfs였고 나랑 지피티랑 같이 한건 그리디방식, bfs가 더 정확하다고 함.
 */

public class 타일점프_1 {
    public static void main(String[] args) {
        int[] num = {2, 2, 1, 2, 1, 1};
        System.out.println("solution(num) = " + (solution(num)));//3

        int[] num2 = {1,0,1,1,3,1,2,1};
        System.out.println("solution(num2) = " + (solution(num2))); //-1

        int[] num3 = {2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1};
        System.out.println("solution(num3) = " + (solution(num3))); //7

        int[] num4 = {1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1};
        System.out.println("solution(num4) = " + (solution(num4))); //6

        int[] num5 = {1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1};  //8
        System.out.println("solution(num5) = " + (solution(num5)));
    }

    private static int solution(int[] num) {
        int tile=0;
        int count=0;
        if (num[0] == 0) {
           return -1;
        }


        while (tile < num.length) {
            int maxStep=0;
            int maxIndex=-1;

            for (int i = tile+1; i <= tile+num[tile]&&i< num.length; i++) { //2,2,1
               //마지막 타일에 정확히 도착할수있는 경우 체크
                if (i == num.length - 1) {
                    return ++count;
                }

                //최적의 점프 위치 찾기 (더 멀리 갈수있는 곳 선택)
                if (i + num[i] > maxStep) {
                    maxStep = i + num[i];
                    maxIndex = i;
                }
            }
            if (maxIndex==-1){
                return -1;
            }

            tile = maxIndex;

            count++;
        }
        return count;
    }
}
