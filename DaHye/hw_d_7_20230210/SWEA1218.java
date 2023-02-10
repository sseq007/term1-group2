package hw_d_7_20230210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
	/*
	 * 괄호 짝짓기 4종류의 괄호문자로 이루어진 문자열 짝이 모두 맞는지 판별하는 프로그램
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case < 11; test_case++) {
			Stack<Character> stack = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			String s = br.readLine();
			boolean flag = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<')
					stack.add(s.charAt(i));
				if (stack.size() != 0) {
					if (s.charAt(i) == ')') {
						if (stack.peek() == '(')
							stack.pop();
						else {
							flag = false;
							break;
						}
					} else if (s.charAt(i) == ']') {
						if (stack.peek() == '[')
							stack.pop();
						else {
							flag = false;
							break;
						}
					} else if (s.charAt(i) == '>') {
						if (stack.peek() == '<')
							stack.pop();
						else {
							flag = false;
							break;
						}
					} else if (s.charAt(i) == '}') {
						if (stack.peek() == '{')
							stack.pop();
						else {
							flag = false;
							break;
						}
					}
				}

			}
			if (flag == false || stack.size() != 0)
				result = 0;

			System.out.println("#" + test_case + " " + result);
		}
	}
}

