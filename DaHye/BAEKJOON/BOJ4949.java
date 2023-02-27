package BAEKJOON;
/*
 * 균형잡힌 세상
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ4949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Stack<Character> stack;
	static String input;
	
	public static void main(String[] args) throws Exception {

		while (true) {
			stack = new Stack<>();
			input = br.readLine();
			if (input.equals("."))
				break;

			for (int i = 0; i < input.length(); i++) {
				char tmp = input.charAt(i);
				if (tmp == '.') {
					if (i != input.length() - 1)
						continue;
					if (stack.empty())
						sb.append("yes" + "\n");
					else
						sb.append("no" + "\n");
				}

				if ((tmp == '[') || tmp == '(') {
					stack.add(tmp);
				}

				if (tmp == ']') {
					if (!stack.empty() && stack.peek() == '[')
						stack.pop();
					else {
						sb.append("no" + "\n");
						break;
					}
				}

				if (tmp == ')') {
					if (!stack.empty() && stack.peek() == '(')
						stack.pop();
					else {
						sb.append("no" + "\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}