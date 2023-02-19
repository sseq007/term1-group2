package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1799 {
    static final int CHECK = 1;
    static final int REMOVE = 0;

    static final int BISHOP = 2;
    static final int[] dx = {-1, -1, 1, 1};
    static final int[] dy = {-1, 1, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, ans = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][][] v;
    static boolean isWidth = true;

    public static void main(String[] args) throws IOException {
        n = stoi(br.readLine());
        map = new int[n][n];
        v = new boolean[n * n][n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        //로직
        //1이 가장 많은 줄의 값을 찾아서 그 부분의 1을 전부 비숍으로 채우고 시작한다.
        int max = Integer.MIN_VALUE;
        int maxNum = -1;
        for (int i = 0; i < n; i++) {
            int width = 0;
            int height = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) width++;
                if (map[j][i] == 1) height++;
            }
            if (max < Math.max(width, height)) {
                if (width >= height) {
                    max = width;
                    isWidth = true;
                }
                else {
                    max = height;
                    isWidth = false;
                }
                maxNum = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (isWidth) {
                if (map[maxNum][i] == 1) map[maxNum][i] = BISHOP;
            } else {
                if (map[i][maxNum] == 1) map[i][maxNum] = BISHOP;
            }
        }

        for (int[] a : map) {
            System.out.println(Arrays.toString(a));
        }

        //정답 출력
//        System.out.println(ans);
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static void solve(int cnt, int x, int y) {
        //마지막 줄에 다다른 경우 비숍을 다 놓은 경우이므로 개수를 update하고 return
        if (x == n) {
            ans = Math.max(ans, cnt);
            return;
        }

        //현재 위치가 0이거나 체크되어 있다면 바로 다음으로 넘어간다.
        boolean flag = true;
        for (int i = 0; i < cnt; i++) {
            if (v[i][x][y]) {
                flag = false;
                break;
            }
        }
        if (map[x][y] == 0 || !flag) {
            //y가 끝에 왔으면 다음 줄로 넘긴다.
            if (y == n - 1) {
            solve(cnt, x + 1, 0);
            } else {
                solve(cnt, x, y + 1);
            }
        } else {
            //현재 위치에 놓는 경우와 놓지 않는 경우로 뻗어나간다.
            //먼저 놓는 경우로 가려면 경로를 전부 체크해준 후 간다.
            exec(cnt, x, y, CHECK);
            map[x][y] = BISHOP;
            if (y == n - 1) {
                solve(cnt + 1, x + 1, 0);
            } else {
                solve(cnt + 1, x, y + 1);
            }
            //다시 체크 한 곳을 복구시킨다.
            exec(cnt, x, y, REMOVE);
            map[x][y] = 1;
            //놓지 않고 다음 칸으로 간다.
            if (y == n - 1) {
                solve(cnt, x + 1, 0);
            } else {
                solve(cnt, x, y + 1);
            }
        }
    }

    static void exec(int cnt, int x, int y, int command) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;

            while (true) {
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                v[cnt][nx][ny] = command == CHECK;
                nx += dx[i];
                ny += dy[i];
            }
        }
    }
}
