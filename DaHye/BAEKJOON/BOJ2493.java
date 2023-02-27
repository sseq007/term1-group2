package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 탑 
 * 입력 
 * - N: 탑의 수 
 * - 탑들의 높이가 직선상에 놓인 순서대로 출력 
 * - 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호
 * 
 * 풀이
 * - top 클래스를 만듦
 * - 요소 각각에 대한 stack을 만들 필요가 없음,,,
 */
class top {
	int height;
	int order;

	public top(int height, int order) {
		super();
		this.height = height;
		this.order = order;
	}

	@Override
	public String toString() {
		return "top [height=" + height + ", order=" + order + "]";
	}
}

public class BOJ2493 {
	static StringBuilder sb;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		top[] topArr = new top[N];
		
		Stack<top> stack = new Stack<>();

		top[] tops = new top[N];

		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			topArr[i] = new top(Integer.parseInt(st.nextToken()), i + 1);
		}
		stack.push(topArr[0]);
		sb.append("0 ");
		for (int i = 1; i < N; i++) {

			while(!stack.isEmpty()) {
				if(topArr[i].height < stack.peek().height) {
					sb.append(stack.peek().order + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append(0 + " ");
			}
			stack.push(topArr[i]);
		}		
		System.out.println(sb);
	}
}