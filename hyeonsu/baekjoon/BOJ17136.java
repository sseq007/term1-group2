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
        
        //색종이 채우기
        for (int i = 1; i <= 5; i++) {
            paperBox[i] = 5;
        }

        //로직
        backtacking(0 , paperCnt);

        System.out.println(min);
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    /*
    @param cnt 붙인 색종이의 개수
    @param startX, startY 시작 할 좌표
    @param paperCnt 붙여야할 종이 개수
     */
    static void backtacking(int cnt, int paperCnt) {
        if (paperCnt <= 0) {
            min = Math.min(min, cnt);
            return;
        }

        //현재 위치에서 그린다.
        for (int i = 5; i > 0; i--) {
            //마지막 1x1 색종이까지 다붙였는데 남은 경우 되돌아간다.
            if (paperBox[1] == 0 && paperCnt > 0) return;
            if (i * i > paperCnt) continue;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] != 1) continue;
                    if (check(i, j, k)) {
                        attach(i, j, k);
                        paperBox[i]--;
                        backtacking(cnt + 1, paperCnt - i * i);
                        remove(i, j, k);
                        paperBox[i]++;
                    }
                }
            }
        }
    }

    /*

     */
    static boolean check(int n, int x, int y) {

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) return false;
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void attach(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                map[i][j] = 2;
            }
        }
    }

    static void remove(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                map[i][j] = 1;
            }
        }
    }
}
