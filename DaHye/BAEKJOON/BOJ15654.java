package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	/*
	 * N과 M(5) 
	 * 입력 - N, M
	 * 출력 - N개의 자연수 중에서 M개를 고른 수열
	 */
	static Integer[] arr;
 	static boolean[] v;
 	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		v = new boolean[N];
		arr = new Integer[N];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		func(arr, new int[M], 0, 0);
		
		System.out.println(sb);
	}

	/*
	 * arr: 원본배열 sel: 선택배열 idx: 원본배열 인덱스 k: 선택배열 인덱스
	 */
	public static void func(Integer[] arr, int[] sel, int idx, int k) {
		// basis part
		if(k == sel.length) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			} sb.append("\n");
			
			return;
		}
		// inductive part
		for(int i = 0; i< arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				func(arr, sel, i, k + 1);
				v[i] = false;
			}
		}
	}
}
