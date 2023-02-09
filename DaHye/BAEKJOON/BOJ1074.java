package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Point {
	int x;
	int y;
}
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

		arr = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		
		func(0, 0, N, 0);
//		func(4, 4, N - 1, 0);
//		func(4, 0, N - 1, 0);
//		func(4, 4, N - 1, 0);


		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

	}

	static public void func(int startX, int startY, int N, int t) {
		int total = (int) Math.pow(2, 2 *N);
		int init = total / 4;
		if(N == 0) return;
		
		if (startX == 0 && startY == 0)
			arr[startX][startY] = 0;
		arr[startX][startY + (int) Math.pow(2, N - 1)] = arr[startX][startY] + init;
		arr[startX + (int) Math.pow(2, N - 1)][startY] = arr[startX][startY]  + 2 * init;
		arr[startX + (int) Math.pow(2, N - 1)][startY + (int) Math.pow(2, N - 1)] = arr[startX][startY]  + 3 * init;
		
		total /= 4;
		N -= 1;
		
		func(startX, startY, N, total);
	}
}
