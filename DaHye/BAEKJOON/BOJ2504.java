package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* 
 * 괄호의 값
 */
public class BOJ2504 {
	static BufferedReader br;
	static Stack<Character> stackOri;
	static Stack<Character> stackCopy;
	public static void main(String[] args)  throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		stackOri = new Stack<>();
		stackCopy = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			stackOri.add(input.charAt(i));
		}
		
		while(!input.isEmpty()) {
			char tmp = stackOri.pop();
			if(tmp == ')') {
				if(stackOri.peek() == '(') {
					
				}
			}
			if(tmp ==']')
		}
	}
}
