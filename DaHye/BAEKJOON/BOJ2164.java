package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue <Integer> cards = new LinkedList<>();
		
		for(int i = 1; i < N + 1; i++) {
			cards.add(i);
		}
		
		while(cards.size() > 1) {
			cards.remove();
			cards.add(cards.peek());
			cards.remove();
			
		}
		System.out.println(cards.peek());
	}

}
