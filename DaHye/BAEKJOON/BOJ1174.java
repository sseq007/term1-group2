package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 줄어드는 수
 * 음이아닌 정수(십진수)
 * N: 1,000,000보다 작거나 같은 자연수
 * N번째 작은 줄어드는 수 출력
 */
public class BOJ1174 {
	static int[] arr = new int[10];
	static boolean[] v = new boolean[10];
	static int N, total;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] argzs) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for(int count = 1; count < 11; count++) {
			func(0, 10, count);			
		}
		
		if(N > 1023) {
			sb.setLength(0);
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	static private void func(int k, int l, int count) {
		if(k == count) {
			total++;
			if(total == N) {
				for (int i = 0; i < count; i++) {
					sb.append(arr[i]);
				}
				return;
			}
			return;
		}
		
		for(int i = 0; i < l; i++) {
			if(v[i]) continue;
			v[i] = true;
			arr[k] = i;
			func(k + 1, arr[k], count);
			v[i] = false;
		}
	}
}


//0 1 2 3 4 5 6 7 8 9 - 10
//10 - 1
//20 21 - 2
//30 31 32 - 3
//40 41 42 - 3