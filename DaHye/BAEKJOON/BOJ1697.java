package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 숨바꼭질
 */
public class BOJ1697 {
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		func(N, K, 0);
		
		System.out.println(time);
	}

	private static void func(int n, int k, int c) {
		Queue<int[]> queue = new LinkedList<>();
		boolean v[] = new boolean[100001];
		
		queue.offer(new int[] {n, 0});
		
		while(!queue.isEmpty()) {
			int[] subin = queue.poll();
			
			if(subin[0] == k) {
				time = subin[1];
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int tmp = 0;
				if(i == 0) tmp = subin[0] * 2;
				if(i == 1) tmp = subin[0] + 1;
				if(i == 2) tmp = subin[0] - 1;
				
				if(tmp > 100000 || tmp < 0) continue;
				if(!v[tmp]) {
					v[tmp] = true;
					queue.add(new int[] {tmp, subin[1] + 1});
				}
			}
		}
	}
}
