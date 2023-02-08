package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2798 {
	/*
	 * 블랙잭
	 * 중복을 허용하지 않고, 3개 숫자 뽑기
	 */
	static int[] arr;
	static int[] sel;
	static int N;
	static int M;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		sel = new int[3];
		st = new StringTokenizer(br.readLine());

		// 배열 정의
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		func(0, 0);
		System.out.println(max);
	}

	static public void func(int idx, int k) {
		if (k == sel.length) {
			int tmp = 0;
			for(int i = 0; i < sel.length; i++) {
				tmp += sel[i];
			}
			if(tmp <= M) max = Math.max(max, tmp);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			func(i + 1, k + 1);
		}
	}
}
