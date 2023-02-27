package BAEKJOON;
/*
 * 색종이 만들기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int white, blue;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < arr.length; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0, 0, N);
		System.out.println(blue + "\n" + white);
	}
	
	static public void func(int r, int c, int N) {
		int sum = 0;
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == N * N) white++;
		else if(sum == 0) blue++;
		else {
			func(r, c, N/2);
			func(r + N/2, c, N/2);
			func(r, c + N/2, N/2);
			func(r + N/2, c + N/2, N/2);
		}
	}
}
