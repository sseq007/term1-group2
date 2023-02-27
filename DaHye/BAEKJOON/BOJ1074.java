package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1074 {
	/*
	 * Z
	 */
	static int N;
	static int r;
	static int c;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(func(N, r, c));

	}

	static public int func(int N, int r, int c) {
		if(N == 0) {
			return 0;
		}
		return 2 * (r % 2) + (c % 2) + 4 * func(N - 1, (int) (r / 2), (int) (c / 2));
	}
}
