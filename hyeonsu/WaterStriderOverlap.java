import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class WaterStriderOverlapPoint {
    int x;
    int y;
    int dir;
    int idx;
    public WaterStriderOverlapPoint(int x, int y, int dir, int idx) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.idx = idx;
    }
}
public class WaterStriderOverlap {
    static final int DOWN = 1;
    static final int RIGHT = 2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int t, testNumber = 1;
    static boolean[][] visited;
    static Queue<WaterStriderOverlapPoint> q;
    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while(t-- > 0) {
            //초기화
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int waterStriderNumber = stoi(st.nextToken());
            visited = new boolean[n][n];
            q = new LinkedList<>();
            for (int i = 0; i < waterStriderNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int x = stoi(st.nextToken());
                int y = stoi(st.nextToken());
                int dir = stoi(st.nextToken());
                q.add(new WaterStriderOverlapPoint(x, y, dir, i + 1));
                visited[x][y] = true;
            }

            //정답 입력
            bw.write("#" + testNumber++ + " " + getWaterStriderNumber(n, waterStriderNumber) + "\n");
        }

        //출력
        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static int getWaterStriderNumber(int n, int num) {
        //싸이클은 총 3번
        for (int i = 3; i > 0; i--) {
            int tmpNum = num;
            //첫번 째 소금쟁이 부터 차례대로 점프
            for (int j = 0; j < num; j++) {
                WaterStriderOverlapPoint cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                if (cur.dir == DOWN) {
                    x += i;
                }
                if (cur.dir == RIGHT) {
                    y += i;
                }

                //점프해서 밖으로 나간 경우
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    //소금쟁이 개수를 하나 차감
                    tmpNum--;
                    continue;
                }
                //점프를 한 곳이 이미 뛰었던 자리라면 바로 return
                if (visited[x][y]) {
                    return cur.idx;
                } else {
                    //아니라면 다시 큐에 들어간다.
                    cur.x = x;
                    cur.y = y;
                    visited[x][y] = true;
                    q.add(cur);
                }
            }
            num = tmpNum;
        }
        return 0;
    }
}
