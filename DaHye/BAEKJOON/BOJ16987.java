package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16987 {
	/*
	 * 틀린 제출을 할 때마다 턱걸이를 5회
	 * 계란으로 계란 치기 -> 각 계란의 내구도: 상대 계란의 무게만큼 깍임 -> 계란의 내구도: 0 -> 꺠짐
	 * 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 걔란을 깨는 문제
	 * 입력
	 * - N: 계란의 수
	 * - S, W: 계란의 내구도, 무게
	 * i + 1번쨰 줄에는 왼쪽에서 i번째 위치한 계란의 내구도 Si와 Wi가 한 칸의 빈 칸을 두고 주어짐
	 */
	
	static int[][] arr;
	static int[] sel;
	static int N;
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] W = new int[N];
		arr = new int[N][N-1];
		sel = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0; i < arr.length; i++) {
			int tmp = 0;
			for(int j = 0; j < arr[i].length + 1; j++) {
				if(j != i) {
					arr[i][tmp] = j + 1;
					tmp++;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		func(0);
//		comb(0, 2, arr);
	}
	
	static public void func(int k) {
		if(k == N) {
			for(int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(sel));
			}
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			// arr[i] 에서 한 개 뽑기 무작위로
			sel[k] = comb(arr[i]);
			func(k + 1);
		}
	}
	
//	static public void comb(int k, int idx, int[][] arr) {
//		if(k == 1) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
//		for(int i = 0; i < arr[idx].length; i++) {
//			sel[k] = arr[idx][i];
//			comb(k + 1, idx, arr);
//		}
//	}
}
