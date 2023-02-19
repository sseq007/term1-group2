package BAEKJOON;
/*
 * 동전 0
 * 준규가 가지고 있는 동전: N종류
 * 동전을 적절히 사용해서 가치의 합을 K로 만들려고 할 때 동전 개수의 최솟값
 * 입력
 * - N, K
 * - 동전의 가치 Ai(오름차순)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

		for (int i = arr.length - 1; i >= 0; i--) {
			count += (K / arr[i]);
			K %= arr[i];
		}

		System.out.println(count);
	}
}
