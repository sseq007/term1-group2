package BAEKJOON;

import java.util.Scanner;

/*
 * 숫자의 개수
 */
public class BOJ2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		long result = a * b * c;

		String numStr = String.valueOf(result);

		for (int i = 0; i < numStr.length(); i++) {
			arr[numStr.charAt(i) - '0']++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
