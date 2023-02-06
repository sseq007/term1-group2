package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 1074 : Z
public class BOJ_1074 {
    static int[] nx = {0, 1, -1, 1};
    static int[] ny = {0, 0, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] s_arr = s.split(" ");

        int N = Integer.parseInt(s_arr[0]);
        int r = Integer.parseInt(s_arr[1]);
        int c = Integer.parseInt(s_arr[2]);

        int size = (int)(Math.pow(2, N));

        int[][] board = new int[size][size];

        int[][] cnt_board = new int[size][size];

        int cnt = 0;

        for (int i = 0 ; i < size ; i+=2) {
            for (int j = 0 ; j < size ; j+=2) {
                for (int q = 0 ; q < 4 ; q++) {
                    int dx = j + nx[q];
                    int dy = i + ny[q];
                    cnt_board[dy][dx] = cnt;
                    cnt++;
                }
            }
        }
    }
}
