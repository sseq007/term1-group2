package baekjoon;

import java.io.*;
import java.util.*;

/*
원형으로 시계방향
규칙 : 1번 자리에 앉은 사람이 공을 받는다.
규칙 : 공을 다른사람에게 던진다.
규칙 : 다시 공을 받은 사람은 다시 공을 던지고 이를 계속 반복한다.
규칙 : 공을 m번보다 적게 받은 사람이 공을 던질 때, 현재 공을 받은 횟수가 홀수번이면 시계방향으로 l번째에게 던진다.
, 짝수번이면 반시계 방향으로 l번째 에게 던진다.
종료조건 : 한사람이 공을 m번 받으면 게임은 끝난다.
목표 : 공을 총 몇번 던지는지 구한다.
 */
public class BOJ1592 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int l = stoi(st.nextToken());

        int[] players = new int[n];
        int max = 1;
        int ballIdx = 0;
        int totalThrowingCnt = 0;
        //로직
        while (max < m) {
            totalThrowingCnt++;
            max = Math.max(++players[ballIdx], max);

            if (players[ballIdx] % 2 == 0) {
                for (int i = 0; i < l; i++) {
                    --ballIdx;
                    if (ballIdx == -1) ballIdx = n - 1;
                }
            } else {
                ballIdx = (ballIdx + l) % n;
            }
        }

        System.out.println(totalThrowingCnt == 0 ? totalThrowingCnt : totalThrowingCnt - 1);
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
