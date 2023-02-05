package BAEKJOON;

import java.util.Scanner;

public class BOJ15649 {
	/* 
	N과 M(1)
	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	 */
	static int[] arr;
	static boolean[] isused;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M + 1];
		isused = new boolean[N + 1];
		
		func(0);
	}
	public static void func(int k) {
		if(k == M) {
			for(int i = 0; i < arr.length - 1; i++) {
				System.out.print(arr[i] + " ");
			}System.out.println();
			return;
		}
		for(int i = 1; i < N + 1; i++) {
			if(!isused[i]) {
				arr[k] = i;
				isused[i] = true;
				func(k + 1);
				isused[i] = false;
			}
		}
		
	}
}
