package BAEKJOON;

import java.util.Scanner;

public class BOJ10994 {
	static char[][] arr;
	static int len;
	static int n;
	static int init;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		 n = sc.nextInt();
		
		// n = 1 -> 1 * 1, n = 2 -> 5 * 5, ... n => 4(n-1)+1
		len = 4 * (n - 1) + 1;
		arr = new char[len][len];
		// n -> n-1 ... -> 1 해주기 위해 필요한 변수
		init = n;
		
		printStar(arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	public static char[][] printStar(char[][] arr) {
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(i == 0 || j == 0) arr[i + 2 * (n - init)][j + 2 * (n - init)] = '*';
				else if(i == len - 1 || j == len - 1) arr[i + 2 * (n - init)][j + 2 * (n - init)] = '*';
				// *이었는데 recursive하게 작동하다가 ' '으로 바뀌는 경우 방지
				else if(arr[i][j] != '*') arr[i][j] = ' ';
			}
		}
		// n = 1 -> 1 * 1, n = 2 -> 5 * 5, ... n => 4(n-1)+1이므로 줄어들 떄는 -4씩
		len -= 4;
		init--;
		if(len > 0) return printStar(arr);
		return arr;
	}

}
