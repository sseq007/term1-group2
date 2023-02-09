package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 1074 : Z
public class BOJ_1074 {
    static int N;
    static int r;
    static int c;

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] s_arr = s.split(" ");

        N = Integer.parseInt(s_arr[0]);
        r = Integer.parseInt(s_arr[1]); // 행
        c = Integer.parseInt(s_arr[2]); // 열

        int size = (int)(Math.pow(2, N));

        recursive(size);

        System.out.println(cnt);
    }

    private static void recursive(int size) {
        if (size == 1) {
            return;
        }

        // 1.
        if (r < size/2 && c < size/2) {
            recursive(size/2);
        }

        // 2.
        else if (r < size/2 && c >= size/2) {
            cnt += (size/2) * (size/2);
            recursive(size/2);
        }

        // 3.
        else if (r >= size/2 && c < size/2) {
            cnt += (size/2) * (size/2) * 2;
            recursive(size/2);
        }

        // 4.
        else {
            cnt += (size/2) * (size/2) * 3;
            recursive(size/2);
        }
    }
}