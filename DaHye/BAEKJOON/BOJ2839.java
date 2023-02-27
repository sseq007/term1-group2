package BAEKJOON;

import java.util.Scanner;

/*
 * 설탕 배달
 * 3키로, 5키로 봉지
 * 상근이가 N키로 배달해야 될 때 가져가야 되는 최대 봉지 수
 */
public class BOJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int N = sc.nextInt();

		while (true) {
			if(N < 3) {
				count = -1;
				break;
			}
			
			if(N % 5 != 0) {
				N -= 3;
				count++;
			}
			
			if(N % 5 == 0) {
				count += (N / 5);
				break;
			}
		}
		
		System.out.println(count);
	}
}
