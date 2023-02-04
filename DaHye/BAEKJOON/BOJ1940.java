package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
	/*
	 주몽
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int count = 0;
		int startIdx = 0;
		int endIdx = N - 1;
		
		Integer[] arr = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		
		Arrays.sort(arr);
		
		while(startIdx < endIdx) {
			int sum = arr[startIdx] + arr[endIdx];
			if(sum < M) {
				startIdx++;
			} else if(sum > M) {
				endIdx--;
			} else if(sum == M) {
				endIdx--;
				startIdx++;
				count++;
			}
		}
		System.out.println(count);
	}
}
