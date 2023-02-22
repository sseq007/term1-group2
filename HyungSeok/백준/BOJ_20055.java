package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 백준 20055 : 컨베이어 벨트 위의 로봇
public class BOJ_20055 {

    static int N;
    static int K;

    static Deque<Integer> up;
    static Deque<Integer> down;

    static int[] A;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nk = bf.readLine();
        String[] nk_arr = nk.split(" ");
        N = Integer.parseInt(nk_arr[0]);
        K = Integer.parseInt(nk_arr[1]);
        answer = 0;

        String s = bf.readLine();
        String[] s_arr = s.split(" ");
        A = new int[s_arr.length];
        visited = new boolean[s_arr.length];

        up = new ArrayDeque<>();
        down = new ArrayDeque<>();

        for (int i = 0 ; i < s_arr.length/2 ; i++) {
            up.addFirst(i);
            A[i] = Integer.parseInt(s_arr[i]);
        }

        for (int i = s_arr.length/2 ; i < s_arr.length ; i++) {
            down.addFirst(i);
            A[i] = Integer.parseInt(s_arr[i]);
        }

        solve();

        System.out.println(answer);
    }

    private static void solve() {

        while (check()) {
            answer++;

            // 1. 한번 회전시키기
            up.addFirst(down.pollFirst());
            down.addLast(up.pollLast());

            // 만약에 내려야하는 위치에 로봇이 있으면 버리기
            if (visited[up.peekLast()]) {
                visited[up.peekLast()] = false;
            }

            // 2. 올린 로봇이 옆으로 한 칸 움직일 수 있는지 보고 움직일 수 있으면 움직이기
            if (up.peekFirst()+1 >= A.length) {
                if (A[up.peekFirst() - (A.length - 1)] > 0 && !visited[up.peekFirst() - (A.length - 1)]) {
                    visited[up.peekFirst() - (A.length - 1)] = true;
                    visited[up.peekFirst()] = false;
                    A[up.peekFirst() - (A.length - 1)]--;
                }
            }
            else {
                if (A[up.peekFirst() + 1] > 0 && !visited[up.peekFirst() + 1]) {
                    visited[up.peekFirst() + 1] = true;
                    visited[up.peekFirst()] = false;
                    A[up.peekFirst() + 1]--;
                }
            }

            // 만약에 내려야하는 위치에 로봇이 있으면 버리기
            if (visited[up.peekLast()]) {
                visited[up.peekLast()] = false;
            }

            // 3. 올리는 위치에 로봇 올리기
            if (A[up.peekFirst()] > 0) {
                visited[up.peekFirst()] = true;
                A[up.peekFirst()]--;
            }
        }
    }

    // 올린 로봇의 개수 확인
    private static boolean check() {

        int cnt = 0;

        for (int i = 0 ; i < A.length ; i++) {
            if (A[i] == 0) {
                cnt++;
            }
        }

        if (cnt >= K){
            return false;
        }
        else {
            return true;
        }
    }
}
