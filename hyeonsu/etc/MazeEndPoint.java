package etc;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Command {
    int dir;
    int moveCnt;

    public Command(int dir, int moveCnt) {
        this.dir = dir;
        this.moveCnt = moveCnt;
    }
}

public class MazeEndPoint {
    /*
    입력 : 시작위치와 어떤방향의 문으로 몇 칸을 이동하라는 숫자를 제공한다.
    조건 : 이동을 하다보면 밖으로나올 수 있는 점퍼가 있다.
    조건 :  점퍼에 도착하면 밖으로 이동 가능
    조건 : 점퍼를 이용하여 밖으로 나왔거나 이동 시 n*n의 칸을 벗어나면 좌표 값은 (0,0)을 갖게된다.
    조건 : 점퍼로 나왔거나 좌표를 벗어났을 경우엔 이후 이동 명령은 무시한다.
    목표 : 주어진 지시(방향과 이동칸수)를 모두 수행 했을 때 도착지점을 출력
     */

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final int JUMPER = -1;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int t, testNumber = 1;
    static int[][] map;
    static Queue<Command> q;

    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while(t-- > 0) {
            //초기화
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int curX = stoi(st.nextToken());
            int curY = stoi(st.nextToken());
            int jumperNum = stoi(st.nextToken());
            map = new int[n][n];

            //점퍼 좌표
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < jumperNum; i++) {
                int r = stoi(st.nextToken()) - 1;
                int c = stoi(st.nextToken()) - 1;
                map[r][c] = JUMPER;
            }

            //이동지시 개수
            q = new LinkedList<>();
            int moveCommandNumber = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < moveCommandNumber; i++) {
                int dir = stoi(st.nextToken());
                int moveCnt = stoi(st.nextToken());
                q.add(new Command(dir, moveCnt));
            }

            //로직
            while(!q.isEmpty()) {
                Command curCommand = q.poll();
                curX += dx[curCommand.dir - 1] * curCommand.moveCnt;
                curY += dy[curCommand.dir - 1] * curCommand.moveCnt;

                // 좌표 밖으로 나갔거나 점퍼라면 0, 0 으로 채우고 빠져나오기
                if (curX < 0 || curX >= n || curY < 0 || curY >= n || map[curX][curY] == JUMPER) {
                    curX = 0;
                    curY = 0;
                    break;
                }
            }

            //정답 입력
            bw.write("#" + testNumber++ + " " + curX + " " + curY + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}
