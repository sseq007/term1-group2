package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 16987 : 계란으로 계란치기
public class BOJ_16987 {
    static int answer = Integer.MIN_VALUE;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

//        arr = new int[N];
        Egg[] eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            String dw = bf.readLine();
            String[] dw_arr = dw.split(" ");

            eggs[i] = new Egg(Integer.parseInt(dw_arr[0]), Integer.parseInt(dw_arr[1]));
        }

        recursive(eggs, new int[N], new boolean[N], 1);

        System.out.println(answer);
    }

    private static void recursive(Egg[] eggs, int[] order, boolean[] visited, int idx) {

        order[0] = 0;

        // basis
        if (idx == order.length) {
            System.out.println(Arrays.toString(order));
            solve(eggs, order);
            return;
        }

        for (int i = 1; i < order.length ; i++){
            if (!visited[i]) {
                visited[i] = true;
                order[idx] = i;
                recursive(eggs, order, visited, idx + 1);
                visited[i] = false;
            }
        }
    }

    private static void solve(Egg[] eggs, int[] order) {
        int idx = 0;

        Egg put_egg;

        for (int i = 1 ; i < order.length ; i++) {
            put_egg = eggs[idx];

            if (put_egg.s > 0 && eggs[order[i]].s > 0) {
                put_egg.s -= eggs[order[i]].w;
                eggs[order[i]].s -= put_egg.w;
            }

        }

        int cnt = 0;

        for (int i = 0 ; i < eggs.length ; i++) {
            if (eggs[i].s <= 0)
                cnt++;
        }

        answer = Math.max(answer, cnt);
    }
}

class Egg {
    int s;
    int w;

    Egg() {
    }

    Egg(int s, int w) {
        this.s = s;
        this.w = w;
    }

    public String toString() {
        return this.s + " " + this.w;
    }
}
