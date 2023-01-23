package 알고리즘스터디.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//비밀번호
public class Problem12334 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int tc=1;tc<=10;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String data = st.nextToken();

			//스택 선언
			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < data.length(); i++) {
				//만약 스택이 비어있다면 push
				if (stack.empty()) {
					stack.push(data.charAt(i));
				} else {
					//스택 peek값가 문자가 같다면 pop
					if (stack.peek() == data.charAt(i)) {
						stack.pop();
					}
					//다르다면 push
					else {
						stack.push(data.charAt(i));
					}
				}
			}
			System.out.print("#"+tc+" ");
			for (Character c : stack) {
				System.out.print(c);
			}
			System.out.println();
			
		}
	}
}
