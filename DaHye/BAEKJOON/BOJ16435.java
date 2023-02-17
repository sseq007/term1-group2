package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 스네이크 버드
 * 과일을 하나 먹으면 길이가 1만큼 늘어남
 * 자기보다 길이가 작거나 같은 높이에 있는 과일을 먹을 수 있음
 * 스네이크버드의 처음길이가 L일 때 늘어날 수 있는 최대 길이
 * 입력
 * - N: 과일의 개수, L: 스네이크버드 초기 길이
 * - h[]: 과일 높이
 */
public class BOJ16435 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int L;
	static int[] h;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		h = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		
		for(int i = 0; i < h.length; i++) {
			if(h[i] <= L) {
				L++;
				continue;
			}
			else break;
		}
		
		System.out.println(L);
	}
}
