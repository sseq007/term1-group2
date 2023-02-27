package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
 * 괄호제거
 * (가 3개 -> 2 / 1 / 0
 */
public class BOJ2800 {
	static BufferedReader br;
	static Stack<Character> stack;
	static int count;
	static ArrayList<Integer> openCh;
	static ArrayList<Integer> closeCh;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		stack = new Stack<>();
		openCh = new ArrayList<>();
		closeCh = new ArrayList<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				count++;
				openCh.add(i);
			}
			if(input.charAt(i) == ')') {
				closeCh.add(i);
			}
		}
		
		func(0, openCh.size());
		
		System.out.println(openCh + "\n" + closeCh);
	}
	static public void func(int k, int m) {
		if(k == m) {
			
		}
	}
}
