package 알고리즘스터디.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//단어 뒤집기 2
public class Problem17413 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		String data = br.readLine();
		//괄호 안이면 true 밖이면 false
		boolean check = false;
		
		for(int i=0;i<data.length();i++) {
			
			if(data.charAt(i)=='<') {
				//괄호 안
				check= true;
				//스택에 다 pop하여 출력
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				sb.append(data.charAt(i));
			}
			else if (data.charAt(i)=='>') {
				//괄호 밖
				check = false;
				sb.append(data.charAt(i));
			}
			//괄호 안이면
			else if (check) {
				sb.append(data.charAt(i));
			}
			//괄호 밖이면
			else if (!check) {
				//공백이면
				if(data.charAt(i)==' ') {
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				}
				//공백이 아니면 
				else {
					stack.push(data.charAt(i));
				}
			}
		}
		//스택에 나머지 출력
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
