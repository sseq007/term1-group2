package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {	
	/* 
	 * 카드2
	 */
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i < N + 1; i++) queue.add(i);
		
		while(queue.size() > 1) {
			queue.poll();
			queue.add(queue.peek());
			queue.poll();
		}
		System.out.println(queue.peek());
	}
}
