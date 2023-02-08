package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA5215 {
	/*
	SWEA 5215 햄버거 다이어트 - 조합으로 풀어보기
	햄버거 재료에 대한 점수, 가게에서 제공하는 재료에 대한 칼로리
	같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합은 칼로리를 제외하고 없다.
	입력
	- T: 테스트 케이스
	- N: 재료의 수, L: 제한 칼로리
	- 맛에 대한 점수, 칼로리
	출력
	- 주어진 제한 칼로리 이하의 조합 가장 맛있는 조합
	 */
	static int[] score;
	static int[] cal;
	static int[] ingrid;
	static int[] arr;
	static int count;
	static int N;
	static int L;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			score = new int[N];
			cal = new int[N];
			ingrid = new int[] {0, 1};
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			func(0);
			System.out.println("#" + test_case + " " + max);
			
		}
	}
	
	public static void func(int k) {
		int tmp = 0;
		int sum = 0;

		if(k == arr.length) {
			for(int i = 0; i < arr.length; i++) {
				tmp += (arr[i] * cal[i]);
			}
			if(tmp <= L) {
				for(int i = 0; i < arr.length; i++) {
					sum += (arr[i] * score[i]);
				}
			}
			max = Math.max(sum, max);
			return;
		}
		
		for(int i = 0; i < ingrid.length; i++) {
			arr[k] = ingrid[i];
			func(k + 1);
		}
	}

}
