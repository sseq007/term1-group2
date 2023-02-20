package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 백준 2206 : 벽 부수고 이동하기
public class BOJ_2206 {

    static int N;
    static int M;
    static int[][] board;
    static ArrayList<Integer[][]> all_board;
    static boolean[][] visited;
    static int wall_cnt;
    static int[] nx = {0, 1, 0, -1};
    static int[] ny = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nm = bf.readLine();
        String[] nm_arr = nm.split(" ");

        N = Integer.parseInt(nm_arr[0]);
        M = Integer.parseInt(nm_arr[1]);
        board = new int[N][M];
        visited = new boolean[N][M];
        all_board = new ArrayList<>();
        wall_cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            String s = bf.readLine();
            for (int j = 0 ; j < M ; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] == 1) {
                    wall_cnt++;
                }
            }
        }

        int answer = bfs(0, 0);

        System.out.println(answer);


    }

    private static void find_AllBoard(int idx, Point p, boolean[][] visited) {
        if (idx == 1) {
            make_board(p);
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    p = new Point(j, i);
                    find_AllBoard(idx + 1, p, visited);
                }
            }
        }
    }

    private static void make_board(Point p) {
        Integer[][] tmp_board = new Integer[N][M];

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                tmp_board[i][j] = board[i][j];
            }
        }

        tmp_board[p.y][p.x] = 0;

        all_board.add(tmp_board);
    }

    private static int bfs(int x, int y) {
        Queue<Point> Q = new LinkedList<>();

        Q.add(new Point(x, y, 1));

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0 ; i < size ; i++) {
                Point p = Q.poll();

                if (p.y == N-1 && p.x == M-1) {
                    return p.depth;
                }

                visited[p.y][p.x] = true;

                for (int j = 0 ; j < 4 ; j++) {
                    int dx = p.x + nx[j];
                    int dy = p.y + ny[j];

                    if (!(dx >= M || dx < 0 || dy >= N || dy < 0) && !visited[dy][dx] && board[dy][dx] == 0) {
                        visited[dy][dx] = true;
                        Q.add(new Point(dx, dy, p.depth+1));
                    }
                }
            }
        }
        return -1;
    }



    static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
