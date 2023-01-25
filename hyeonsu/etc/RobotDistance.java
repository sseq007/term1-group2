package etc;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RobotDistance {
    /*
    로봇들은 벽을 넘지 못함.
    본인이 갈 수 있는 방향으로만 직진할 수 있음.
    로봇의 초기 위치를 넘어가지 못함.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Point> pointInfo;
    static int t, testNumber = 1;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());

        while(t-- > 0) {
            //초기화
            pointInfo = new LinkedList<>();
            int sumDistance = 0;
            int n = stoi(br.readLine());
            map = new char[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                    if (map[i][j] == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {
                        pointInfo.add(new Point(i, j));
                    }
                }
            }

            //로직
            while(!pointInfo.isEmpty()) {
                Point cur = pointInfo.poll();
                sumDistance += getDistance(map[cur.x][cur.y], n, cur);
            }

            //정답 입력
            bw.write("#" + testNumber++ + " " + sumDistance + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static int getDistance(char type, int n, Point cur) {
        int distCnt = 0;
        Point p = new Point(cur.x, cur.y);

        //오른쪽
        while(++p.y < n && map[p.x][p.y] == 'S') {
            distCnt++;
        }
        p.y = cur.y;

        //왼쪽
        if(type == 'B' || type == 'C') {
            while(--p.y >= 0 && map[p.x][p.y] == 'S') {
                distCnt++;
            }
        }
        p.y = cur.y;

        //상, 하
        if (type == 'C') {
            while(--p.x >= 0 && map[p.x][p.y] == 'S') {
                distCnt++;
            }
            p.x = cur.x;
            while(++p.x < n && map[p.x][p.y] == 'S') {
                distCnt++;
            }
        }
        return distCnt;
    }
}
