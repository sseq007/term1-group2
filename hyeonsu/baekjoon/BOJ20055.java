package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20055 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k, zero = 0, stage = 1;
    static int[][] belt;
    static boolean[][] isrobotExist;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //초기화
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        k = stoi(st.nextToken());
        belt = new int[2][n];
        isrobotExist = new boolean[2][n];
        //벨트 생성
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            belt[0][i] = stoi(st.nextToken());
        }
        for (int i = n - 1; i >= 0; i--) {
            belt[1][i] = stoi(st.nextToken());
        }

        //로직
        while (true) {
            rotate();
            move();
            putOn();
            if (canExit()) break;
            stage++;
            for (int[] a : belt) {
                System.out.println(Arrays.toString(a));
            }
            for (boolean[] a : isrobotExist) {
                System.out.println(Arrays.toString(a));
            }
        }

        //정답 출력
        System.out.println(stage);
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static void rotate() {
        //벨트 배열과 로봇 배열 모두 한칸 씩 회전한다.
        int tmpN_1 = belt[0][n - 1];
        int tmpN_2 = belt[1][0];
        boolean robot_1 = isrobotExist[0][n - 1];
        boolean robot_2 = isrobotExist[1][0];

        //상단 벨트
        for (int i = n - 1; i > 0; i--) {
            belt[0][i] = belt[0][i - 1];
            isrobotExist[0][i] = isrobotExist[0][i - 1];
        }
        //하단 벨트
        for (int i = 0; i < n - 1; i++) {
            belt[1][i] = belt[1][i + 1];
            isrobotExist[1][i] = isrobotExist[1][i + 1];
        }

        belt[1][n - 1] = tmpN_1;
        belt[0][0] = tmpN_2;
        isrobotExist[1][n - 1] = robot_1;
        isrobotExist[0][0] = robot_2;

        //내리는 위치의 로봇을 내린다.
        isrobotExist[0][n - 1] = false;
    }

    static void move() {
        //가장 먼저 벨트에 올라간 로봇부터 차례대로 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
        //큐가 비어있다면 로봇이 하나도 올라가있지 않다는 뜻이므로 뛴다.
        if (q.isEmpty()) return;

        int len = q.size();
        for (int i = 0; i < len; i++) {
            //들어온 순서대로 로봇을 이동시킨다.
            Pair curRobot = q.poll();
            //올라가는 위치
            if (curRobot.x == 1 && curRobot.y == 0) {
                //이동할 수 있는가?
                if (!isrobotExist[0][0] && belt[0][0] >= 1) {
                    //이동시키고 내구도를 -1한다.
                    isrobotExist[0][0] = true;
                    isrobotExist[1][0] = false;
                    curRobot.x = 0;
                    curRobot.y = 0;
                    belt[0][0]--;
                    if (belt[curRobot.x][curRobot.y] == 0) zero++;
                }
            }
            //평면 위치
            else {
                //상단 벨트
                if (curRobot.x == 0) {
                    if (!isrobotExist[0][curRobot.y + 1] && belt[0][curRobot.y + 1] >= 1) {
                        //이동시키고 내구도를 -1한다.
                        isrobotExist[0][curRobot.y + 1] = true;
                        isrobotExist[curRobot.x][curRobot.y] = false;
                        curRobot.y++;
                        belt[curRobot.x][curRobot.y]--;
                        //내구도 체크
                        if (belt[curRobot.x][curRobot.y] == 0) zero++;
                    }
                }
                //하단 벨트
                else {
                    if (!isrobotExist[1][curRobot.y - 1] && belt[1][curRobot.y] >= 1) {
                        //이동시키고 내구도를 -1한다.
                        isrobotExist[1][curRobot.y - 1] = true;
                        isrobotExist[1][curRobot.y] = false;
                        curRobot.y--;
                        belt[curRobot.x][curRobot.y]--;
                        //내구도 체크
                        if (belt[curRobot.x][curRobot.y] == 0) zero++;
                    }

                }
            }
            //옮긴 위치가 내리는 위치가 아닐 때만 큐에 넣는다.
            if (curRobot.x == 0 && curRobot.y == n - 1) {
                isrobotExist[0][n - 1] = false;
            } else {
                q.add(curRobot);
            }
        }
    }

    static void putOn() {
        //올리는 위치에 내구도가 1 이상인 경우 올린다. 이 때 내구도는 1 감소한다.
        if (!isrobotExist[0][0] && belt[0][0] >= 1) {
            q.add(new Pair(0, 0));
            isrobotExist[0][0] = true;
            belt[0][0]--;
            if (belt[0][0] == 0) zero++;
        }
    }

    static boolean canExit() {
        return zero == k;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
