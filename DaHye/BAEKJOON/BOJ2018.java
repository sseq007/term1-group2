package BAEKJOON;
import java.util.Scanner;

public class BOJ2018 {
	/*
	수들의 합
	어떠한 자연수 N의 연속된 자연수의 합의 개수
	투 포인터 이용
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int startIdx = 0;
		int endIdx = 0;
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int sum = arr[0];
		while(endIdx < N - 1) {
			if(sum < N) {
				endIdx++;
				sum += arr[endIdx];
			} else if(sum > N) {
				sum -=arr[startIdx];
				startIdx++;
			} else if(sum == N) {
				endIdx++;
				sum += arr[endIdx];
				count++;
			}
		}
		System.out.println(count);
	}

}
