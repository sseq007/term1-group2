package BAEKJOON;

import java.util.Scanner;

public class BOJ10819 {
	/*
	차이를 최대로
	정수의 순서를 적절히 바꿔가면서 최댓값 구하기
	첫째 줄: N
	둘째 줄: 배열 A에 있는 정수 
	 */
	static int N;
	static int[][] arr;
	static int count = 0;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		for(int i = 0; i < N; i++) input[i] = sc.nextInt();
		
		int tmp = 1;
		
		for(int i = 1; i <= N; i++) {
			tmp *= i;
		}
		
		// 모든 조합의 경우(idx 순서)를 담고있는 배열 arr
		arr = new int[tmp][N];

		boolean[] isVisited = new boolean[N + 1];
		dfs(0, isVisited, new int[N]);
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < tmp; i++) {
			int tmp_result = 0;
			for(int j = 0; j < N - 1; j++) {
				tmp_result += Math.abs(input[arr[i][j] % N] - input[arr[i][j + 1] % N]);
			}
			max = Math.max(max, tmp_result);
		}
		System.out.println(max);
	}

	public static void dfs(int depth, boolean[] isVisited, int[] nums) {
		if (depth == N) {
			for (int i = 0; i < nums.length; i++) {
				arr[count][i] = nums[i];
			}
			count++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				nums[depth] = i;
				dfs(depth + 1, isVisited, nums);
				isVisited[i] = false;
			}
		}
	}

}
