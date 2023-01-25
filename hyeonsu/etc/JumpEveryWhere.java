package etc;

import java.io.*;
import java.util.*;
/*
목표 : 여러 명의 참가자의 최종 상금의 합을 구하기
조건 : 참가자는 시작좌표와 점프 횟수를 부여받고 횟수 만큼 뛴다.
조건 : 해당 칸의 앞자리는 방향이고 뒷자리는 점프 칸수
조건 :
 */
class Player {
    int x;
    int y;
    int cnt;

    public Player(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class JumpEveryWhere {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int t, tNumber = 1;
    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while (t-- > 0) {
            //초기화
            Queue<Player> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int n = stoi(st.nextToken());
            int sumPrizeMoney = 0;
            //맵 초기화
            int[][] map = new int[x][y];
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    map[i][j] = stoi(st.nextToken());
                }
            }
            //참가자 수 만큼 시작위치, 점프 횟수 받기
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                q.add(new Player(stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1, stoi(st.nextToken())));
            }

            //함정 수 만큼 받고 함정의 x, y 좌표 * 수 만큼 받는다.
            st = new StringTokenizer(br.readLine());
            int trapNum = stoi(st.nextToken());
            for (int i = 0; i < trapNum; i++) {
                map[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1] = 0;
            }

            //로직
            while (!q.isEmpty()) {
                boolean isSuccessed = true;
                Player cur = q.poll();
                //점프 횟수 만큼 이동
                for (int i = 0; i < cur.cnt; i++) {
                    int dir = map[cur.x][cur.y] / 10;
                    int cnt = map[cur.x][cur.y] % 10;

                    cur.x = (dx[dir - 1] * cnt) + cur.x;
                    cur.y = (dy[dir - 1] * cnt) + cur.y;

                    if (cur.x < 0 || cur.x >= x || cur.y < 0 || cur.y >= y || map[cur.x][cur.y] == 0) {
                        isSuccessed = false;
                        break;
                    }
                }

                sumPrizeMoney += isSuccessed ? map[cur.x][cur.y] * 100 - 1000 : -1000;
            }

            //정답입력
            bw.write("#" + tNumber++ + " " + sumPrizeMoney + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}