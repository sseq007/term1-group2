package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074 {

    static int[] dx = { 0, 1, 0};
    static int[] dy = { 1, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, r, c, len, cnt, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        len = (int) Math.pow(2, n);

        //로직
        recur(0, 0, 0, 0);

        System.out.println(ans);
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static void recur(int len, int idx, int cnt) {

        recur();
    }
}
