package BAEKJOON;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1927 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			
			if(x == 0) {
				if(pq.size() == 0) {
					sb.append(0 + "\n");
					continue;
				}
				sb.append(pq.poll() + "\n");
			} else pq.add(x);
		}
		System.out.println(sb);
	}
}
