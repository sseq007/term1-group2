package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
    static final int N = 10;
    static int[][] map = new int[N][N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static int ans = -1;
    static int paperCnt = 0;
    static int[] paperBox = new int[6];
    static int min = 0x7fffffff;

    public static void main(String[] args) throws IOException {
        //맵 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 1) paperCnt++;
            }
        }

        //로직
        backtacking(0, 0, 0, paperCnt);
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    /*
    @param cnt 붙인 색종이의 개수
    @param startX, startY 시작 할 좌표
    @param paperCnt 붙여야할 종이 개수
     */
    static void backtacking(int cnt, int startX, int startY, int paperCnt) {
        if (paperCnt == 0) {
            min = Math.min(min, cnt);
            return;
        }

        //현재 위치에서 그린다.
        for (int i = 1; i <= 5; i++) {
            if (paperBox[1] == 0 && paperCnt > 0) return;
            for (int j = startX; j < N; j++) {
                for (int k = startY; k < N; k++) {
                    if (attach(i)) {
                        backtacking(cnt + 1, );
                    }
                }
            }
        }
    }

    /*

     */
    static boolean attach(int n) {
        return false;
    }

    static void remove(int n) {

    }
}
