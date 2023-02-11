package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Egg {
    int s;
    int w;
    
    Egg(int s, int w) {
        this.s = s;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Egg [s=" + s + ", w=" + w + "]";
    }
    
}
public class BOJ16987 {
    /*
     * 계란으로 계란치기
     * 틀린 제출을 할 때마다 턱걸이를 5회 계란으로 계란 치기 -> 각 계란의 내구도: 상대 계란의 무게만큼 깍임 -> 계란의 내구도: 0 ->
     * 꺠짐 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 걔란을 깨는 문제 입력 - N: 계란의 수
     * - S, W: 계란의 내구도, 무게 i + 1번쨰 줄에는 왼쪽에서 i번째 위치한 계란의 내구도 Si와 Wi가 한 칸의 빈 칸을 두고 주어짐
     */

    static int N;
    static int[] S;
    static int[] W;
    static int[] sCopy;
    static int[] arr;
    static int max;
    static int count;
    static Egg[] eggs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        eggs = new Egg[N];
//        S = new int[N];
//        W = new int[N];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            S[i] = Integer.parseInt(st.nextToken());
//            W[i] = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        arr = new int[N];
        
        if(N == 1) {
            max = 0;
            System.out.println(max);
            return;
        }
        
        func(0);
        System.out.println(max);
    }

    static public void func(int k) {
        int count = 0;
        if (k == N) {
            Egg[] eggCopy = new Egg[N];
            
            for(int i = 0; i < N; i++) {
            	eggCopy[i] = new Egg(0, 0);
            }
            
            for(int i = 0; i < N; i++) {
            	eggCopy[i].s = eggs[i].s;
            	eggCopy[i].w = eggs[i].w;
            }
            for (int i = 0; i < N; i++) {
                if (eggCopy[i].s <= 0) continue;
                if(eggCopy[arr[i]].s <= 0) continue;
                eggCopy[i].s -= eggs[arr[i]].w;
                eggCopy[arr[i]].s -= eggs[i].w;
            }

            for (int i = 0; i < eggCopy.length; i++) {
                if (eggCopy[i].s <= 0)
                    count++;
            }
            max = Math.max(count, max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == k) {
                continue;
            }
            
            arr[k] = i;
            func(k + 1);
        }
    }
}
