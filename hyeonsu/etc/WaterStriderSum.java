package etc;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*

 */
class WaterStrider {
    int x;
    int y;
    int dir;

    public WaterStrider(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
public class WaterStriderSum {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int t, tNumber = 1;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while (t-- > 0) {
            //초기화
            st = new StringTokenizer(br.readLine());
            Queue<WaterStrider> q = new LinkedList<>();
            int n = stoi(st.nextToken());
            int waterStriderNumber = stoi(st.nextToken());
            checked = new boolean[n][n];

            for (int i = 0; i < waterStriderNumber; i++) {
                st = new StringTokenizer(br.readLine());
                q.add(new WaterStrider(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
            }

            //로직
            for (int i = 3; i > 0; i--) {
                int size = waterStriderNumber;
                for (int j = 0; j < size; j++) {
                    WaterStrider cur = q.poll();
                    int nx = cur.x + (dx[cur.dir - 1] * i);
                    int ny = cur.y + (dy[cur.dir - 1] * i);
                    checked[cur.x][cur.y] = false;

                    //좌표 밖으로 나가거나 소금쟁이가 머물러 있는곳에 뛸 경우
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || checked[nx][ny]) {
                        waterStriderNumber--;
                        continue;
                    }

                    if (i == 1) checked[nx][ny] = true;
                    cur.x = nx;
                    cur.y = ny;
                    q.add(cur);
                }
            }

            //정답 입력
            bw.write("#" + tNumber++ + " " + waterStriderNumber + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
