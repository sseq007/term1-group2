package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class cheese {
    int x;
    int y;
    int cnt;

    public cheese(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class BOJ2638 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<cheese> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int y = stoi(st.nextToken());
        int x = stoi(st.nextToken());
        map = new int[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                int cur = stoi(st.nextToken());
                map[i][j] = cur == 1 ? 1 : 0;
            }
        }
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
