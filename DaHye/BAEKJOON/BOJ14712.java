package BAEKJOON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ14712 {

	static int[] arr;
	static int[] square;
	static int count = 0;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N * M];
		square = new int[] { 0, 1 };

		func(0);
		System.out.println(count);
	}

	public static void func(int k) {
		// 사각형이 있는지 확인하기 위한 변수
		boolean flag = false;
		if (k == arr.length) {
			for (int i = 0; i < M * N - N - 1; i++) {
				if((i + 1) % N == 0) {
					continue; 
				}
				if ((arr[i] == 1) && (arr[i + 1] == 1) && (arr[i + N] == 1) && (arr[i + N + 1] == 1)) {
					flag = true;
					break;
				}
			}
			if (flag == false) count++;
			return;
		}
		
		for (int i = 0; i < square.length; i++) {
			arr[k] = i;
			func(k + 1);
		}
	}
}
