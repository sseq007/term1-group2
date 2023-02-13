package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static final int NONE_CHECK = 0;
    static final int BLOCKED_CHECK = 1;
    static final int UNBLOCKED_CHECK = 2;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, min = Integer.MAX_VALUE;
    static boolean[][] map;
    static int[][] v;
    static Queue<Point_1> q = new ArrayDeque<>(1000001);

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new boolean[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0' == 1;
            }
        }

        //로직
        bfs();

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs() {
        q.add(new Point_1(0, 0, false, 1, 0, 0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Point_1 cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                min = cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                //좌표를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //이미 방문한 경우
                if (v[nx][ny] && nx == cur.prev_x && ny == cur.prev_y) continue;
                //벽이면서 이미 벽을 한번 뚫고 간 경우 돌아가야함.
                if (map[nx][ny] && cur.isBroken) continue;
                //벽이면서 뚫은 적이 없는 경우 뚫고간다.
                if (map[nx][ny] && !cur.isBroken) {
                    v[nx][ny] = true;
                    q.add(new Point_1(nx, ny, true, cur.cnt + 1, cur.x, cur.y));
                }
                //벽이 아닌 경우 그냥 간다.
                else {
                    v[nx][ny] = true;
                    q.add(new Point_1(nx, ny, cur.isBroken, cur.cnt + 1, cur.x, cur.y));
                }
            }
        }
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}

class Point_1{
    int x;
    int y;
    boolean isBroken;
    int cnt;
    int prev_x;
    int prev_y;

    public Point_1(int x, int y, boolean isBroken, int cnt, int prev_x, int prev_y) {
        this.x = x;
        this.y = y;
        this.isBroken = isBroken;
        this.cnt = cnt;
        this.prev_x = prev_x;
         this.prev_y = prev_y;
    }
}
