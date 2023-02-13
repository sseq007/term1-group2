package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	/*
	 * 구간 합 구하기 5 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때 처리하는 프로그램 입력 - N, M: 표의 크기, 합을 구해야
	 * 하는 횟수 - 표 채우기 ... - x1, y1, x2, y2
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] S = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++)
				S[i + 1][j] = S[i + 1][j - 1] + Integer.parseInt(st.nextToken());
		}

//		for(int i = 0; i < S.length; i++) {
//				System.out.println(Arrays.toString(S[i]));
//		}

		for (int test_case = 0; test_case < M; test_case++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = 0;

			for (int i = x1; i < x2 + 1; i++) {

				sum += (S[i][y2] - S[i][y1 - 1]);
			}

			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}

