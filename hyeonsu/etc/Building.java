package etc;

import java.io.*;
import java.util.StringTokenizer;

public class Building {
    static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int t, testNumber = 1;
    static char[][] map;
    static int[][] height;

    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while(t-- > 0) {
            //초기화
            int max = Integer.MIN_VALUE;
            int n = stoi(br.readLine());
            map = new char[n][n];
            height = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            //로직
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean flag = true;
                    if (map[i][j] == 'G') continue;

                    for (int k = 0; k < 8; k++) {
                        int r = dx[k] + i;
                        int c = dy[k] + j;

                        if (r < 0 || r >= n || c < 0 || c >= n) continue;
                        if (map[r][c] == 'G') {
                            max = Math.max(max, 2);
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        int sum = 0;
                        for (int k = 0; k < n; k++) {
                            if (map[i][k] == 'B') sum++;
                        }
                        for (int k = 0; k < n; k++) {
                            if (map[k][j] == 'B') sum++;
                        }
                        max = Math.max(max, sum - 1);
                    }
                }
            }



            //정답 입력
            bw.write("#" + testNumber++ + " " + max + "\n");
        }

        //출력
        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
