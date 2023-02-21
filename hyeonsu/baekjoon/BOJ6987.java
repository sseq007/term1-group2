package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6987 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Team[][] resultTable = new Team[4][6];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                int win = stoi(st.nextToken());
                int draw = stoi(st.nextToken());
                int lose = stoi(st.nextToken());
                resultTable[i][j] = new Team(win, draw, lose);
            }
        }

        //로직
        for (int i = 0; i < 4; i++) {
            ans = 0;
            solve(i, 0);
            bw.write(ans + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static int stoi(String s) {return Integer.parseInt(s);}

    static void solve(int tableNum, int curTeam) {
        if (curTeam == 6) {
            ans = 1;
            return;
        }

        //현재 팀에 대해서 반대의 팀이 있어야 맞는 정보이다.
        Team team = resultTable[tableNum][curTeam];
        for (int i = 0; i < 6; i++) {
            if (i == curTeam) continue;
            Team otherTeam = resultTable[tableNum][i];
            if (team.win == otherTeam.lose && team.lose == otherTeam.win && team.draw == otherTeam.draw) {
                solve(tableNum, curTeam + 1);
            }
        }

    }

    static class Team {
        int win;
        int draw;
        int lose;

        public Team(int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "win=" + win +
                    ", draw=" + draw +
                    ", lose=" + lose +
                    '}';
        }
    }
}
