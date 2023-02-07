package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14712 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] map;

    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new boolean[n][m];

        //로직
        play(0, 0, 0);

        //정답 출력
        System.out.println(ans);
    }

    static void play(int x, int y, int sum) {
        if (x == n && y == m) {
            ans = sum;
            return;
        }

        if (check(x, y)) {
            map[x][y] = true;
            if (y == m - 1) {
                play(x + 1, 0, sum + 1);
            } else {
                play(x, y + 1, sum + 1);
            }
        }
        map[x][y] = false;
        if (y == m - 1) {
            play(x + 1, 0, sum);
        } else {
            play(x, y + 1, sum);
        }
    }

    /*
    해당 위치에 넴모를 놓았을 때 2*2가 되지 않는지 체크하는 함수
     */
    static boolean check(int x, int y) {
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < x + 2; j++) {
                if (i < 0 || i >= n || j < 0 || j >= m) return false;
                if (!map[i][j]) return true;
            }
        }
        return false;
    }

    static void remove(int x, int y) {
        for (int i = 0; i < x + 2; i++) {
            for (int j = 0; j < y + 2; j++) {
                map[i][j] = false;
            }
        }
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
