package BAEKJOON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ14712 {
	
	static int[] arr;
	static int[] square;
	static boolean[] v;
	static HashSet<boolean[]> set = new HashSet<>();
	static int count = 0;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N * M];
		square = new int[] {0, 1};
		v = new boolean[N * M];
		
		func(0);
		System.out.println(count);
	}
	static int m = - 1;
	public static void func(int k){
		boolean flag = false;
		for(int i = 0; i < M * N - N - 1; i++) {
			if((v[i] == true) && (v[i + 1] == true) && (v[i + N] == true) && (v[i + N + 1] == true)) {
				flag = true;
			}
		}
		if(flag == false) count++;
		
		for(int i = 0; i < v.length; i++) {
			if(m < i && !v[i]) {
				v[i] = true;
				func(k + 1);
				v[i] = false;
				m = i;
			}
		}
	}
}
