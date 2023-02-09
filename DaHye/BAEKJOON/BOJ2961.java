package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2961 {
	/*
	 * 도영이가 만든 맛있는 음식
	 * S: 신맛, B: 쓴맛
	 * 재료를 섞어서 신 맛과 쓴맛의 차이를 작게
	 * 입력
	 * - N: 재료의 개수
	 * - 신맛, 쓴맛
	 * 
	 */
	static int[] S;
	static int[] B;
	static int min;
	static boolean sel[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		
		S = new int[N];
		B = new int[N];
		sel = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		func(new boolean[N], 0, 0);
		
		System.out.println(min);
	}
	
	static public void func(boolean[] sel, int idx, int k) {
		if(idx == sel.length) {
			
			if(k != 0) {
				int sumS = 1;
				int sumB = 0;

				for(int i = 0; i < sel.length; i++) {
					if(sel[i]) {
						sumS *= S[i];
						sumB += B[i];
					}
				}
				int minTmp = Math.abs(sumS - sumB);
				min = Math.min(min, minTmp);
			}

			return;
		}
		sel[idx] = true;
		func(sel, idx + 1, k + 1);
		sel[idx] = false;
		func(sel, idx + 1, k);
	}
}